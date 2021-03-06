package tamaized.beatdownstick.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemBeatDownStick extends Item {

	public ItemBeatDownStick(ItemGroup group) {
		super(new Item.Properties().group(group).maxStackSize(1).defaultMaxDamage(21));
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		boolean flag = false;
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			float dmg;
			dmg = (!e.isNonBoss()) ? (e.getMaxHealth() / 10) : (e.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			e.attackEntityFrom(DamageSource.GENERIC, dmg);
			flag = true;
		} else if (entity instanceof MultiPartEntityPart) {
			MultiPartEntityPart e = (MultiPartEntityPart) entity;
			if (e.parent instanceof EntityDragon) // Must be DamageSource.Player for dragon
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
			else if (e.parent instanceof EntityLivingBase) {
				EntityLivingBase living = (EntityLivingBase) e.parent;
				living.attackEntityFrom(DamageSource.GENERIC, (!e.isNonBoss()) ? (living.getMaxHealth() / 10) : (living.getMaxHealth()));
			}
			flag = true;
		}
		if (flag) {
			if (player.abilities.isCreativeMode)
				return true;
			stack.damageItem(1, player);
			return true;
		}
		return false;
	}
}

package tamaized.beatdownstick.common.items;

import tamaized.tammodized.common.items.TamItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ItemBeatDownStick extends TamItem {


	public ItemBeatDownStick(CreativeTabs tab, String n, int maxStackSize) {
		super(tab, n, maxStackSize);
		setFull3D();
		setMaxDamage(21);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		boolean flag = false;
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			float dmg = 0;
			dmg = (!e.isNonBoss()) ? (e.getMaxHealth() / 10) : (e.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			e.attackEntityFrom(DamageSource.GENERIC, dmg);
			flag = true;
		} else if (entity instanceof MultiPartEntityPart) {
			MultiPartEntityPart e = (MultiPartEntityPart) entity;
			if (e.parent instanceof EntityDragon) // Must be DamageSource.Player for dragon
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
			else if (e.parent != null && e.parent instanceof EntityLivingBase) {
				EntityLivingBase living = (EntityLivingBase) e.parent;
				living.attackEntityFrom(DamageSource.GENERIC, (!e.isNonBoss()) ? (living.getMaxHealth() / 10) : (living.getMaxHealth()));
			}
			flag = true;
		}
		if (flag) {
			if (player.capabilities.isCreativeMode)
				return true;
			stack.damageItem(1, player);
			return true;
		}
		return false;
	}
}

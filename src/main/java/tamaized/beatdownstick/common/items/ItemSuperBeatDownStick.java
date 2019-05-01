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
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import tamaized.beatdownstick.BeatDownStick;

public class ItemSuperBeatDownStick extends Item {

	public ItemSuperBeatDownStick(ItemGroup group) {
		super(new Item.Properties().maxStackSize(1).group(group));
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			e.attackEntityFrom(BeatDownStick.DAMAGE_SOURCE_ANNIHILATE, Float.MAX_VALUE);
			return true;
		} else if (entity instanceof MultiPartEntityPart) {
			MultiPartEntityPart e = (MultiPartEntityPart) entity;
			if (e.parent instanceof EntityDragon) // Must be DamageSource.Player for dragon
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), Float.MAX_VALUE);
			else if (e.parent instanceof EntityLivingBase) {
				EntityLivingBase living = (EntityLivingBase) e.parent;
				living.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
			}
		}
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

}

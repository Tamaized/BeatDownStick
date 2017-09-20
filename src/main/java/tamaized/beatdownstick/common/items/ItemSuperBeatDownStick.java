package tamaized.beatdownstick.common.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tamaized.beatdownstick.registry.DamageSourceRegistry;
import tamaized.tammodized.common.items.TamItem;

public class ItemSuperBeatDownStick extends TamItem {

	public ItemSuperBeatDownStick(CreativeTabs tab, String n, int maxStackSize) {
		super(tab, n, maxStackSize);
		setFull3D();
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			e.attackEntityFrom(DamageSourceRegistry.dmgOp, Float.MAX_VALUE);
			return true;
		} else if (entity instanceof MultiPartEntityPart) {
			MultiPartEntityPart e = (MultiPartEntityPart) entity;
			if (e.parent instanceof EntityDragon) // Must be DamageSource.Player for dragon
				e.attackEntityFrom(DamageSource.causePlayerDamage(player), Float.MAX_VALUE);
			else if (e.parent != null && e.parent instanceof EntityLivingBase) {
				EntityLivingBase living = (EntityLivingBase) e.parent;
				living.attackEntityFrom(DamageSource.GENERIC, Float.MAX_VALUE);
			}
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

}

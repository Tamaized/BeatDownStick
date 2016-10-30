package Tamaized.BeatDownStick.items;

import Tamaized.BeatDownStick.BeatDownStick;
import Tamaized.TamModized.items.TamItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSuperCheesyBurger extends TamItem {

	public ItemSuperCheesyBurger(CreativeTabs tab, String n, int maxStackSize) {
		super(tab, n, maxStackSize);
		setFull3D();
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			e.attackEntityFrom(BeatDownStick.damageSource.dmgOp, e.getMaxHealth() * 5);
			return true;
		} else if (entity instanceof EntityDragonPart) { // We can't tap into the Dragon's stats so we hardcode it. Also must be DamageSource.Player
			EntityDragonPart e = (EntityDragonPart) entity;
			e.attackEntityFrom(DamageSource.causePlayerDamage(player), 500);
			return true;
		}
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

}

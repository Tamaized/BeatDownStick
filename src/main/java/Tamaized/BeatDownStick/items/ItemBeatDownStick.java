package Tamaized.BeatDownStick.items;

import Tamaized.TamModized.items.TamItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

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
		} else if (entity instanceof EntityDragonPart) { // We can't tap into the Dragon's stats so we hardcode it. Also must be DamageSource.Player
			EntityDragonPart e = (EntityDragonPart) entity;
			e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
			flag = true;
		}
		if (flag) {
			if (player.capabilities.isCreativeMode) return true;
			stack.damageItem(1, player);
			if (stack.getCount() <= 0) stack = ItemStack.EMPTY;
			return true;
		}
		return false;
	}
	/*
	 * @Override public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) { super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected); if (stack.getCount() <= 0) { if (entityIn instanceof EntityPlayer) { EntityPlayer player = (EntityPlayer) entityIn; if (player.inventory.mainInventory.size() - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.mainInventory.get(itemSlot))) { player.inventory.mainInventory.set(itemSlot, ItemStack.EMPTY); } else if (player.inventory.armorInventory.size() - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.armorInventory[itemSlot])) { player.inventory.armorInventory.set(itemSlot, ItemStack.EMPTY); } else if (player.inventory.offHandInventory.size() - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.offHandInventory[itemSlot])) { player.inventory.offHandInventory.set(itemSlot, ItemStack.EMPTY); } } } }
	 */
}

package Tamaized.BeatDownStick.items;

import Tamaized.TamModized.items.TamItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemCheesyBurger extends TamItem {

	public ItemCheesyBurger(CreativeTabs tab, String n, int maxStackSize) {
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
			dmg = e.getMaxHealth(); // THIS BROKE IN 1.8+ //(entity instanceof IBossDisplayData) ? (e.getMaxHealth() / 10) : (e.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			e.attackEntityFrom(DamageSource.generic, dmg);
			flag = true;
		} else if (entity instanceof EntityDragonPart) { // We can't tap into the Dragon's stats so we hardcode it. Also must be DamageSource.Player
			EntityDragonPart e = (EntityDragonPart) entity;
			e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
			flag = true;
		}
		if (flag) {
			if (player.capabilities.isCreativeMode) return true;
			stack.damageItem(1, player);
			return true;
		}
		return false;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
		if (stack.stackSize <= 0) {
			if (entityIn instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entityIn;
				if (player.inventory.mainInventory.length - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.mainInventory[itemSlot])) {
					player.inventory.mainInventory[itemSlot] = null;
				} else if (player.inventory.armorInventory.length - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.armorInventory[itemSlot])) {
					player.inventory.armorInventory[itemSlot] = null;
				} else if (player.inventory.offHandInventory.length - 1 >= itemSlot && ItemStack.areItemStacksEqual(stack, player.inventory.offHandInventory[itemSlot])) {
					player.inventory.offHandInventory[itemSlot] = null;
				}
			}
		}
	}

}

package Tamaized.BeatDownStick.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBeatDownStick extends Item {
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		boolean flag = false;
		if(entity instanceof EntityLivingBase){
			EntityLivingBase e = (EntityLivingBase) entity;
			float dmg = 0;
			dmg = (entity instanceof IBossDisplayData) ? (e.getMaxHealth()/10) : (e.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			e.attackEntityFrom(DamageSource.generic, dmg);
			flag = true;
		}else if(entity instanceof EntityDragonPart){ //We can't tap into the Dragon's stats so we hardcode it. Also must be DamageSource.Player
			EntityDragonPart e = (EntityDragonPart) entity;
			e.attackEntityFrom(DamageSource.causePlayerDamage(player), 20);
			flag = true;
		}
		if(flag){
			if(player.capabilities.isCreativeMode) return true;
			stack.damageItem(1, player);
			if(stack.getItemDamage() == 0) player.destroyCurrentEquippedItem();
	        return true;
		}
		return false;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
	    return false;
    }

}

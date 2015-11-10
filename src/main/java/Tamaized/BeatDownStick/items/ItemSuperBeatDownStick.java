package Tamaized.BeatDownStick.items;

import Tamaized.BeatDownStick.Root;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSuperBeatDownStick extends Item {
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
		if(entity instanceof EntityLivingBase){
			EntityLivingBase e = (EntityLivingBase) entity;
			e.attackEntityFrom(Root.dmgOp, e.getMaxHealth()*5);
			return true;
		}else if(entity instanceof EntityDragonPart){ //We can't tap into the Dragon's stats so we hardcode it. Also must be DamageSource.Player
			EntityDragonPart e = (EntityDragonPart) entity;
			e.attackEntityFrom(DamageSource.causePlayerDamage(player), 500);
			return true;
		}
		return false;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack){
	    return true;
    }

}

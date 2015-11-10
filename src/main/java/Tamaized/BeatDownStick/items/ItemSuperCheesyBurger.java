package Tamaized.BeatDownStick.items;

import static net.minecraftforge.common.ChestGenHooks.DUNGEON_CHEST;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragonPart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraftforge.common.ChestGenHooks;
import Tamaized.BeatDownStick.Root;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSuperCheesyBurger extends Item {
	
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
	
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
    	Random rand = new Random();
    	world.setBlock(x, y+1, z, Blocks.chest, 0, 2);
        TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y+1, z);

        if (tileentitychest != null)
        {
            WeightedRandomChestContent.generateChestContents(rand, ChestGenHooks.getItems(DUNGEON_CHEST, rand), tileentitychest, ChestGenHooks.getCount(DUNGEON_CHEST, rand));
        }
    	return true;
    }

}

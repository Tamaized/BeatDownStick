package Tamaized.BeatDownStick.items;

import Tamaized.BeatDownStick.BeatDownStick;
import Tamaized.TamModized.items.TamItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MultiPartEntityPart;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSuperBeatDownStick extends TamItem {

	public ItemSuperBeatDownStick(CreativeTabs tab, String n, int maxStackSize) {
		super(tab, n, maxStackSize);
		setFull3D();
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
		if (entity instanceof EntityLivingBase) {
			EntityLivingBase e = (EntityLivingBase) entity;
			e.attackEntityFrom(BeatDownStick.damageSource.dmgOp, Float.MAX_VALUE);
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
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// worldIn.setBlockState(pos.up(), Blocks.CHEST.getDefaultState());
		// TileEntityChest tile = (TileEntityChest) worldIn.getTileEntity(pos.up());
		// tile.setLootTable(LootTableList.CHESTS_JUNGLE_TEMPLE, worldIn.rand.nextLong());
		return super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}

}

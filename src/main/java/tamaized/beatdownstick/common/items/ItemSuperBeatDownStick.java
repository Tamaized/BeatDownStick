package tamaized.beatdownstick.common.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.entity.PartEntity;
import tamaized.beatdownstick.BeatDownStick;

public class ItemSuperBeatDownStick extends Item {

	public ItemSuperBeatDownStick(Properties properties) {
		super(properties);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		if (entity instanceof LivingEntity living) {
			living.hurt(BeatDownStick.DAMAGE_SOURCE_ANNIHILATE, Float.MAX_VALUE);
			return true;
		} else if (entity instanceof PartEntity<?> part) {
			if (part.getParent() instanceof EnderDragon) // Must be DamageSource.Player for dragon
				part.hurt(DamageSource.playerAttack(player), Float.MAX_VALUE);
			else if (part.getParent() instanceof LivingEntity living) {
				living.hurt(DamageSource.GENERIC, Float.MAX_VALUE);
			}
		}
		return false;
	}

	@Override
	public boolean isFoil(ItemStack stack) {
		return true;
	}
}

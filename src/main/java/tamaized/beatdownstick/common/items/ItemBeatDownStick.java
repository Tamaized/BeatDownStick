package tamaized.beatdownstick.common.items;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.entity.PartEntity;

public class ItemBeatDownStick extends Item {

	public ItemBeatDownStick(Properties properties) {
		super(properties);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		boolean flag = false;
		if (entity instanceof LivingEntity living) {
			float dmg;
			dmg = (!living.canChangeDimensions()) ? (living.getMaxHealth() / 10) : (living.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			living.hurt(DamageSource.GENERIC, dmg);
			flag = true;
		} else if (entity instanceof PartEntity<?> part) {
			if (part.getParent() instanceof EnderDragon) // Must be DamageSource.Player for dragon
				part.hurt(DamageSource.playerAttack(player), 20);
			else if (part.getParent() instanceof LivingEntity living) {
				living.hurt(DamageSource.GENERIC, (!part.canChangeDimensions()) ? (living.getMaxHealth() / 10) : (living.getMaxHealth()));
			}
			flag = true;
		}
		if (flag) {
			if (player.getAbilities().instabuild)
				return true;
			stack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(player.swingingArm));
			return true;
		}
		return false;
	}
}

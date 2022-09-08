package tamaized.beatdownstick.common.items;

import net.minecraft.network.protocol.game.ClientboundAnimatePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.entity.PartEntity;
import tamaized.beatdownstick.BeatDownStick;

public class ItemBeatDownStick extends Item {

	private final boolean superStick;

	public ItemBeatDownStick(Properties properties, boolean superStick) {
		super(properties);
		this.superStick = superStick;
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity) {
		boolean flag = false;
		float dmg;
		boolean dontOneShot = entity.getType().is(BeatDownStick.DONT_ONE_SHOT);
		if (entity instanceof LivingEntity living) {
			dmg = this.superStick ? Float.MAX_VALUE : dontOneShot ? (living.getMaxHealth() / 10) : (living.getMaxHealth()); // do 10% instead of 100% dmg to bosses
			player.playSound(BeatDownStick.WHAM.get(), 1.0F, 1.0F);
			if (living.hurt(DamageSource.GENERIC, dmg))
				flag = true;
		} else if (entity instanceof PartEntity<?> part) {
			if (part.getParent() instanceof EnderDragon) { // Must be DamageSource.Player for dragon
				player.playSound(BeatDownStick.WHAM.get(), 1.0F, 1.0F);
				if (part.hurt(DamageSource.playerAttack(player), 20))
					flag = true;
			} else if (part.getParent() instanceof LivingEntity living) {
				dmg = this.superStick ? Float.MAX_VALUE : dontOneShot ? (living.getMaxHealth() / 10) : (living.getMaxHealth());
				player.playSound(BeatDownStick.WHAM.get(), 1.0F, 1.0F);
				if (living.hurt(DamageSource.GENERIC, dmg))
					flag = true;
			}
		}
		if (flag) {
			if (!player.getAbilities().instabuild && !this.superStick)
				stack.hurtAndBreak(1, player, user -> user.broadcastBreakEvent(player.swingingArm));
			if (player.getLevel() instanceof ServerLevel server) {
				server.getChunkSource().broadcastAndSend(player, new ClientboundAnimatePacket(entity, 5));
			}
			return true;
		}
		return false;
	}
}

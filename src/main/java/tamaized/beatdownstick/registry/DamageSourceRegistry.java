package tamaized.beatdownstick.registry;

import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.common.damagesource.DamageSourceAnnihilate;
import net.minecraft.util.DamageSource;

public class DamageSourceRegistry {

	public static final DamageSource dmgOp = new DamageSourceAnnihilate(BeatDownStick.MODID + ".annihilate").setDamageBypassesArmor().setDamageAllowedInCreativeMode();

}

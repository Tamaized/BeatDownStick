package Tamaized.BeatDownStick.registry;

import Tamaized.BeatDownStick.BeatDownStick;
import Tamaized.BeatDownStick.damageSource.DamageSourceAnnihilate;
import net.minecraft.util.DamageSource;

public class DamageSourceRegistry {

	public static final DamageSource dmgOp = new DamageSourceAnnihilate(BeatDownStick.modid + ".annihilate").setDamageBypassesArmor().setDamageAllowedInCreativeMode();

}

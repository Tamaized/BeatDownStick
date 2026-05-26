package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class ModDamageTypes {

	public final ResourceKey<DamageType> ANNIHILATE = ResourceKey.create(Registries.DAMAGE_TYPE, Identifier.fromNamespaceAndPath(BeatDownStick.MODID, "annihilate"));

}

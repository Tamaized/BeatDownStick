package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class ModDamageTypes {

	public final ResourceKey<DamageType> ANNIHILATE = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(BeatDownStick.MODID, "annihilate"));

}

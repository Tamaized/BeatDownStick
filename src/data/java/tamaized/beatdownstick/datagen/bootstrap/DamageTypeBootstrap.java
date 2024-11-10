package tamaized.beatdownstick.datagen.bootstrap;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.registry.ModDamageTypes;

@Component
public class DamageTypeBootstrap {

	@Autowired
	private ModDamageTypes damageTypes;

	public RegistrySetBuilder bootstrap(RegistrySetBuilder builder) {
		return builder.add(Registries.DAMAGE_TYPE, context -> {
			context.register(damageTypes.ANNIHILATE, new DamageType("beatdownstick.annihilate", DamageScaling.NEVER, 0.1F));
		});
	}

}

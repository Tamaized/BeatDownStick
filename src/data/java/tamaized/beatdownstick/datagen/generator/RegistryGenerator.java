package tamaized.beatdownstick.datagen.generator;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.RegistryProvider;
import tamaized.beatdownstick.datagen.loot.LootModifierProviderFactory;

@Component
public class RegistryGenerator {

	@Autowired
	private RegistryProvider registryProvider;

	public void generate(GatherDataEvent event) {
		registryProvider.retrieve(event);
	}

}

package tamaized.beatdownstick.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.datagen.loot.LootModifierProviderFactory;
import tamaized.beatdownstick.datagen.tag.DamageTypeTagProviderFactory;
import tamaized.beatdownstick.datagen.tag.ModEntityTypeTagsProviderFactory;

@Component
public class DataGenerators {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private DamageTypeTagProviderFactory damageTypeTagProviderFactory;

	@Autowired
	private ModEntityTypeTagsProviderFactory entityTypeTagsProviderFactory;

	@Autowired
	private LootModifierProviderFactory lootModifierProviderFactory;

	@PostConstruct
	private void register(IEventBus bus) {
		bus.addListener(GatherDataEvent.class, event -> {
			registryProvider.retrieve(event); // Ensure this is loaded first

			// Tags
			event.getGenerator().addProvider(event.includeServer(), damageTypeTagProviderFactory.make(event));
			event.getGenerator().addProvider(event.includeServer(), entityTypeTagsProviderFactory.make(event));

			// GLM
			event.getGenerator().addProvider(event.includeServer(), lootModifierProviderFactory.make(event));
		});
	}

}

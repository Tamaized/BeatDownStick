package tamaized.beatdownstick.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.datagen.tag.DamageTypeTagProvider;
import tamaized.beatdownstick.datagen.tag.ModEntityTypeTagsProvider;

@Component
public class DataGenerators {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private DamageTypeTagProvider damageTypeTagProviderFactory;

	@Autowired
	private ModEntityTypeTagsProvider entityTypeTagsProvider;

	@PostConstruct
	private void register(IEventBus bus) {
		bus.addListener(GatherDataEvent.class, event -> {
			registryProvider.retrieve(event); // Ensure this is loaded first
			event.getGenerator().addProvider(event.includeServer(), damageTypeTagProviderFactory.make(event));
			event.getGenerator().addProvider(event.includeServer(), entityTypeTagsProvider.make(event));
		});
	}

}

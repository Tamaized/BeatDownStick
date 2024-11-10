package tamaized.beatdownstick.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;

@Component
public class DataGenerators {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private DamageTypeTagProvider damageTypeTagProviderFactory;

	@PostConstruct
	private void register(IEventBus bus) {
		bus.addListener(GatherDataEvent.class, event -> {
			registryProvider.retrieve(event); // Ensure this is loaded first
			event.getGenerator().addProvider(event.includeServer(), damageTypeTagProviderFactory.make(event));
		});
	}

}

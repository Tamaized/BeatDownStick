package tamaized.beatdownstick.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.datagen.assets.AssetsGenerator;
import tamaized.beatdownstick.datagen.data.DataGenerator;
import tamaized.beatdownstick.datagen.generator.*;

@Component
public class DataGenerators {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private AssetsGenerator assets;

	@Autowired
	private DataGenerator data;

	@PostConstruct
	private void register(IEventBus bus) {
		bus.addListener(GatherDataEvent.Client.class, event -> {
			registryProvider.retrieve(event);
			assets.generate(event);
			data.generate(event);
		});
	}

}

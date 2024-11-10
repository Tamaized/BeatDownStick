package tamaized.beatdownstick.datagen;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.datagen.generator.*;

@Component
public class DataGenerators {

	@Autowired
	private RegistryGenerator registry;

	@Autowired
	private TagGenerator tags;

	@Autowired
	private LootGenerator loot;

	@Autowired
	private BakedModelGenerator bakedModels;

	@Autowired
	private LangGenerator lang;

	@Autowired
	private MetadataGenerator metadata;

	@PostConstruct
	private void register(IEventBus bus) {
		bus.addListener(GatherDataEvent.class, event -> {
			registry.generate(event);

			tags.generate(event);
			loot.generate(event);

			bakedModels.generate(event);
			lang.generate(event);

			metadata.generate(event);
		});
	}

}

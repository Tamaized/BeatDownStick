package tamaized.beatdownstick.datagen.generator;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.tag.DamageTypeTagProviderFactory;
import tamaized.beatdownstick.datagen.tag.ModEntityTypeTagsProviderFactory;

@Component
public class LootGenerator {

	@Autowired
	private DamageTypeTagProviderFactory damageTypeTagProviderFactory;

	@Autowired
	private ModEntityTypeTagsProviderFactory entityTypeTagsProviderFactory;

	public void generate(GatherDataEvent event) {
		event.getGenerator().addProvider(event.includeServer(), damageTypeTagProviderFactory.make(event));
		event.getGenerator().addProvider(event.includeServer(), entityTypeTagsProviderFactory.make(event));
	}

}

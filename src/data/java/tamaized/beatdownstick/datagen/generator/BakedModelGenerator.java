package tamaized.beatdownstick.datagen.generator;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.bakedmodel.ItemModelProviderFactory;

@Component
public class BakedModelGenerator {

	@Autowired
	private ItemModelProviderFactory itemModelProviderFactory;

	public void generate(GatherDataEvent event) {
		event.getGenerator().addProvider(event.includeClient(), itemModelProviderFactory.make(event));
	}

}

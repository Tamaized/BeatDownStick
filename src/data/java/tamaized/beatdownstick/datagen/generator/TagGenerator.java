package tamaized.beatdownstick.datagen.generator;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.loot.LootModifierProviderFactory;

@Component
public class TagGenerator {

	@Autowired
	private LootModifierProviderFactory lootModifierProviderFactory;

	public void generate(GatherDataEvent event) {
		event.getGenerator().addProvider(event.includeServer(), lootModifierProviderFactory.make(event));
	}

}

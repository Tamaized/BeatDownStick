package tamaized.beatdownstick.datagen.data.loot;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;

@Component
public class LootGenerator {

	@Autowired
	private LootModifierProviderFactory lootModifierProviderFactory;

	public void generate(GatherDataEvent.Client event) {
		event.getGenerator().addProvider(true, lootModifierProviderFactory.make(event));
	}

}

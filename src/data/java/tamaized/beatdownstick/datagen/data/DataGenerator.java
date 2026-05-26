package tamaized.beatdownstick.datagen.data;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.data.loot.LootGenerator;
import tamaized.beatdownstick.datagen.data.tag.TagGenerator;

@Component
public class DataGenerator {

	@Autowired
	private TagGenerator tags;

	@Autowired
	private LootGenerator loot;

	public void generate(GatherDataEvent.Client event) {
		tags.generate(event);
		loot.generate(event);
	}

}

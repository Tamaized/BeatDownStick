package tamaized.beatdownstick.datagen.assets;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.assets.bakedmodel.BakedModelGenerator;
import tamaized.beatdownstick.datagen.assets.lang.LangGenerator;

@Component
public class AssetsGenerator {

	@Autowired
	private BakedModelGenerator bakedModels;

	@Autowired
	private LangGenerator lang;

	public void generate(GatherDataEvent.Client event) {
		bakedModels.generate(event);
		lang.generate(event);
	}

}

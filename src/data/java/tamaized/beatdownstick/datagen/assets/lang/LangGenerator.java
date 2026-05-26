package tamaized.beatdownstick.datagen.assets.lang;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;

@Component
public class LangGenerator {

	@Autowired
	private LangProviderFactory langProviderFactory;

	public void generate(GatherDataEvent.Client event) {
		event.getGenerator().addProvider(true, langProviderFactory.make(event));
	}

}

package tamaized.beatdownstick.datagen.generator;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.datagen.lang.LangProviderFactory;

@Component
public class LangGenerator {

	@Autowired
	private LangProviderFactory langProviderFactory;

	public void generate(GatherDataEvent event) {
		event.getGenerator().addProvider(event.includeClient(), langProviderFactory.make(event));
	}

}

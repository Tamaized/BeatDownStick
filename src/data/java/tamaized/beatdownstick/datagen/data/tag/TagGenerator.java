package tamaized.beatdownstick.datagen.data.tag;

import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;

@Component
public class TagGenerator {

	@Autowired
	private DamageTypeTagProviderFactory damageTypeTagProviderFactory;

	@Autowired
	private ModEntityTypeTagsProviderFactory entityTypeTagsProviderFactory;

	public void generate(GatherDataEvent.Client event) {
		event.getGenerator().addProvider(true, damageTypeTagProviderFactory.make(event));
		event.getGenerator().addProvider(true, entityTypeTagsProviderFactory.make(event));
	}

}

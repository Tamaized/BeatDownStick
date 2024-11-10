package tamaized.beatdownstick.registry;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;

import java.util.function.Consumer;

@Component
public class ModCreativeTabs {

	@Autowired
	private ModItems items;

	@PostConstruct
	private void setup(IEventBus modBus) {
		modBus.addListener((Consumer<BuildCreativeModeTabContentsEvent>) event -> {
			if (event.getTabKey() == CreativeModeTabs.COMBAT) {
				event.accept(items.BEAT_DOWN_STICK::value);
				event.accept(items.SUPER_BEAT_DOWN_STICK::value);
			}
		});
	}

}

package tamaized.beatdownstick.datagen.assets.bakedmodel.item;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.registry.ModItems;

@Component
public class SuperBeatDownStickItemModelHolder extends BeatDownStickItemModelHolder {

	@Autowired
	private ModItems items;

	@Override
	protected DeferredHolder<Item, ? extends Item> itemForName() {
		return items.SUPER_BEAT_DOWN_STICK;
	}
}

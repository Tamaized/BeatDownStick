package tamaized.beatdownstick.datagen.assets.bakedmodel.item;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.registry.ModItems;
import tamaized.datagenutil.assets.bakedmodel.item.BasicItemModelHolder;

import java.util.Optional;
import java.util.function.Supplier;

@Component
public class BeatDownStickItemModelHolder extends BasicItemModelHolder {

	@Autowired
	private ModItems items;

	@Override
	protected DeferredHolder<Item, ? extends Item> itemForName() {
		return items.BEAT_DOWN_STICK;
	}

	@Override
	protected Optional<Supplier<Item>> textureDonor() {
		return Optional.of(() -> Items.STICK);
	}

	@Override
	protected ModelTemplate template() {
		return ModelTemplates.FLAT_HANDHELD_ITEM;
	}
}

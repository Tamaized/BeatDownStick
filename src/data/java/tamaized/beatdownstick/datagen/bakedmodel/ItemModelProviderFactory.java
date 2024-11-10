package tamaized.beatdownstick.datagen.bakedmodel;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.registry.ModItems;

@Component
public class ItemModelProviderFactory {

	@Autowired
	private ModItems items;

	public ItemModelProvider make(GatherDataEvent event) {
		return new ItemModelProvider(
			event.getGenerator().getPackOutput(),
			BeatDownStick.MODID,
			event.getExistingFileHelper()
		) {
			@Override
			protected void registerModels() {
				handheld(items.BEAT_DOWN_STICK, Items.STICK);
				handheld(items.SUPER_BEAT_DOWN_STICK, Items.STICK);
			}

			private void handheld(Holder<Item> item, Item texture) {
				withExistingParent(item.getRegisteredName(), "item/handheld").texture("layer0", BuiltInRegistries.ITEM.getKey(texture).withPrefix("item/"));
			}
		};
	}

}

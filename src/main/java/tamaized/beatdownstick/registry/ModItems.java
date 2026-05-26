package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import tamaized.beanification.Component;
import tamaized.beatdownstick.common.items.ItemBeatDownStick;
import tamaized.regutil.RegUtil;

@Component
public class ModItems {

	public final DeferredHolder<Item, ItemBeatDownStick> BEAT_DOWN_STICK = RegUtil.register(Registries.ITEM, "beatdownstick",
		(id) -> new ItemBeatDownStick(
			new Item.Properties()
				.setId(ResourceKey.create(Registries.ITEM, id))
				.stacksTo(1)
				.durability(21),
			false
		)
	);

	public final DeferredHolder<Item, ItemBeatDownStick> SUPER_BEAT_DOWN_STICK = RegUtil.register(Registries.ITEM, "superbeatdownstick",
		(id) -> new ItemBeatDownStick(
			new Item.Properties()
				.setId(ResourceKey.create(Registries.ITEM, id))
				.stacksTo(1),
			true
		)
	);

}

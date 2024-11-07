package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import tamaized.beanification.Component;
import tamaized.beatdownstick.common.items.ItemBeatDownStick;
import tamaized.regutil.RegUtil;

import java.util.function.Supplier;

@Component
public class ModItems {

	private DeferredRegister<Item> REGISTRY = RegUtil.create(Registries.ITEM);

	public final Supplier<Item> BEAT_DOWN_STICK = REGISTRY.register("beatdownstick", () -> new ItemBeatDownStick(new Item.Properties().stacksTo(1).durability(21), false));
	public final Supplier<Item> SUPER_BEAT_DOWN_STICK = REGISTRY.register("superbeatdownstick", () -> new ItemBeatDownStick(new Item.Properties().stacksTo(1), true));

}

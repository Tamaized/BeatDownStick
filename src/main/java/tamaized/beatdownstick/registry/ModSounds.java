package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredRegister;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.common.items.ItemBeatDownStick;
import tamaized.regutil.RegUtil;

import java.util.function.Supplier;

@Component
public class ModSounds {

	private DeferredRegister<SoundEvent> REGISTRY = RegUtil.create(Registries.SOUND_EVENT);

	public final Supplier<SoundEvent> WHAM = REGISTRY.register("item.wham", () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(BeatDownStick.MODID, "item.wham")));

}

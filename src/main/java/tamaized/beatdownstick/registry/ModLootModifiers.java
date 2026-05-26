package tamaized.beatdownstick.registry;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import tamaized.beanification.Component;
import tamaized.beatdownstick.common.loot.BeatDownStickModifier;
import tamaized.regutil.RegUtil;

import java.util.function.Supplier;

@Component
public class ModLootModifiers {

	public final Supplier<MapCodec<BeatDownStickModifier>> BEAT_DOWN_STICK_LOOT_INJECTION = RegUtil.register(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS,
		"loot_injection",
		() -> BeatDownStickModifier.CODEC
	);

}

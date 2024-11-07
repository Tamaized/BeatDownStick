package tamaized.beatdownstick.registry;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import tamaized.beanification.Component;
import tamaized.beatdownstick.common.loot.BeatDownStickModifier;
import tamaized.regutil.RegUtil;

import java.util.function.Supplier;

@Component
public class ModLootModifiers {

	private final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_REGISTRY = RegUtil.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS);


	public final Supplier<MapCodec<BeatDownStickModifier>> BEAT_DOWN_STICK_LOOT_INJECTION = LOOT_MODIFIER_REGISTRY.register("loot_injection", () -> BeatDownStickModifier.CODEC);

}

package tamaized.beatdownstick.common.loot;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import tamaized.beanification.Autowired;
import tamaized.beanification.Configurable;
import tamaized.beatdownstick.registry.ModItems;

@Configurable
public class BeatDownStickModifier extends LootModifier {

	public static final MapCodec<BeatDownStickModifier> CODEC = RecordCodecBuilder.mapCodec(inst ->
		LootModifier.codecStart(inst).apply(inst, BeatDownStickModifier::new)
	);

	@Autowired
	private ModItems items;

	public BeatDownStickModifier(LootItemCondition[] conditions, int priority) {
		super(conditions, priority);
	}

	@Override
	protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		generatedLoot.add(items.BEAT_DOWN_STICK.value().getDefaultInstance());
		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}
}

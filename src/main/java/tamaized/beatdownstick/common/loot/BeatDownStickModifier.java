package tamaized.beatdownstick.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;
import tamaized.beanification.Autowired;
import tamaized.beanification.Configurable;
import tamaized.beatdownstick.registry.ModItems;

@Configurable
public class BeatDownStickModifier extends LootModifier {

	public static final MapCodec<BeatDownStickModifier> CODEC = RecordCodecBuilder.mapCodec(inst -> LootModifier.codecStart(inst).and(
		Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter(o -> o.chance)
	).apply(inst, BeatDownStickModifier::new));

	@Autowired
	private ModItems items;

	private final float chance;

	public BeatDownStickModifier(LootItemCondition[] conditions, float chance) {
		super(conditions);
		this.chance = chance;
	}

	@Override
	protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
		Vec3 origin = context.getParamOrNull(LootContextParams.ORIGIN);
		if (origin == null) return generatedLoot;
		if (context.getRandom().nextFloat() < this.chance) {
			generatedLoot.add(items.BEAT_DOWN_STICK.value().getDefaultInstance());
		}
		return generatedLoot;
	}

	@Override
	public MapCodec<? extends IGlobalLootModifier> codec() {
		return CODEC;
	}
}

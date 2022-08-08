package tamaized.beatdownstick.common.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;
import tamaized.beatdownstick.BeatDownStick;

public class BeatDownStickModifier extends LootModifier {

	public static final Codec<BeatDownStickModifier> CODEC = RecordCodecBuilder.create(inst -> LootModifier.codecStart(inst).and(
					Codec.floatRange(0.0F, 1.0F).fieldOf("chance").forGetter(o -> o.chance)
	).apply(inst, BeatDownStickModifier::new));

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
			generatedLoot.add(BeatDownStick.BEAT_DOWN_STICK.get().getDefaultInstance());
		}
		return generatedLoot;
	}

	@Override
	public Codec<? extends IGlobalLootModifier> codec() {
		return null;
	}
}

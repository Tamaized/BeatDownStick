package tamaized.beatdownstick.datagen.loot;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.common.loot.BeatDownStickModifier;
import tamaized.beatdownstick.datagen.RegistryProvider;
import tamaized.beatdownstick.util.NamespaceUtils;

@Component
public class LootModifierProviderFactory {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private NamespaceUtils namespaceUtils;

	public GlobalLootModifierProvider make(GatherDataEvent event) {
		return new GlobalLootModifierProvider(
			event.getGenerator().getPackOutput(),
			registryProvider.retrieve(event),
			BeatDownStick.MODID
		) {
			@Override
			protected void start() {
				add(BuiltInLootTables.DESERT_PYRAMID, 0.1F);
				add(BuiltInLootTables.SIMPLE_DUNGEON, 0.05F);
				add(BuiltInLootTables.IGLOO_CHEST, 0.2F);
				add(BuiltInLootTables.JUNGLE_TEMPLE, 0.2F);
				add(BuiltInLootTables.SHIPWRECK_SUPPLY, 0.15F);
				add(BuiltInLootTables.STRONGHOLD_CORRIDOR, 0.15F);
				add(BuiltInLootTables.STRONGHOLD_CROSSING, 0.15F);
				add(BuiltInLootTables.STRONGHOLD_LIBRARY, 0.2F);
			}

			private void add(ResourceKey<LootTable> table, float chance) {
				add(namespaceUtils.slash(table), new BeatDownStickModifier(new LootItemCondition[]{
					LootTableIdCondition.builder(table.location()).build()
				}, chance));
			}
		};
	}

}

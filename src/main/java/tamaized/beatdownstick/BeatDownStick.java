package tamaized.beatdownstick;


import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;
import tamaized.beatdownstick.common.damagesource.DamageSourceAnnihilate;
import tamaized.beatdownstick.common.items.ItemBeatDownStick;
import tamaized.beatdownstick.common.items.ItemSuperBeatDownStick;

import java.util.Objects;

@Mod(BeatDownStick.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BeatDownStick {

	public static final String MODID = "beatdownstick";

	public static final DamageSource DAMAGE_SOURCE_ANNIHILATE = new DamageSourceAnnihilate(BeatDownStick.MODID + ".annihilate").setDamageBypassesArmor().setDamageAllowedInCreativeMode();


	@ObjectHolder("beatdownstick")
	public static final Item beatDownStick = Items.AIR;
	@ObjectHolder("superbeatdownstick")
	public static final Item superBeatDownStick = Items.AIR;

	public BeatDownStick() {
		MinecraftForge.EVENT_BUS.addListener(this::modifyLootTables);
	}

	public static ResourceLocation getRegName(ForgeRegistryEntry entry) {
		return Objects.requireNonNull(entry.getRegistryName());
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(

				assign(new ItemBeatDownStick(ItemGroup.COMBAT), "beatdownstick"),

				assign(new ItemSuperBeatDownStick(ItemGroup.COMBAT), "superbeatdownstick")

		);
	}

	private static Item assign(Item item, String name) {
		return item

				.setRegistryName(MODID, name);
	}

	private void modifyLootTables(LootTableLoadEvent e) {
		if (e.getTable() == null)
			return;
		LootPool pool = e.getTable().getPool("main");
		//noinspection ConstantConditions; getPool can return null
		if (pool == null)
			return;

		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON) ||

				e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE) ||

				e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
			pool.addEntry(new LootEntryItem(beatDownStick, 1, 0, new LootFunction[0], new LootCondition[0], getRegName(beatDownStick).toString()));
		}
	}

}

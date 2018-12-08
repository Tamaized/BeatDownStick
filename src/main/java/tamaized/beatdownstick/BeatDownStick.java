package tamaized.beatdownstick;

import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tamaized.beatdownstick.registry.DamageSourceRegistry;
import tamaized.beatdownstick.registry.ItemRegistry;

@Mod(modid = BeatDownStick.MODID, name = "Beat Down Stick", version = BeatDownStick.VERSION, acceptedMinecraftVersions = "[1.12,)")
public class BeatDownStick {

	public static final String MODID = "beatdownstick";
	public static final String VERSION = "${version}";

	static {
		new ItemRegistry();
		new DamageSourceRegistry();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public void modifyLootTables(LootTableLoadEvent e) {
		if (e.getTable() == null)
			return;
		LootPool pool = e.getTable().getPool("main");
		if (pool == null)
			return;

		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON) ||

				e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE) ||

				e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING) ||

				e.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
			pool.addEntry(new LootEntryItem(ItemRegistry.beatDownStick, 1, 0, new LootFunction[0], new LootCondition[0], MODID + ":beatdownstick"));
			// pool.addEntry(new LootEntryItem(items.cheesyBurger, 1, 0, new LootFunction[0], new LootCondition[0], MODID + ":cheesyburger"));
		}
	}

}

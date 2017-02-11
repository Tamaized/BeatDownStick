package Tamaized.BeatDownStick;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Tamaized.BeatDownStick.registry.DamageSourceRegistry;
import Tamaized.BeatDownStick.registry.ItemRegistry;
import Tamaized.TamModized.TamModBase;
import Tamaized.TamModized.TamModized;
import Tamaized.TamModized.proxy.AbstractProxy;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = BeatDownStick.modid, name = "Beat Down Stick", version = BeatDownStick.version, dependencies = "required-before:" + TamModized.modid + "@[" + TamModized.version + ",)")
public class BeatDownStick extends TamModBase {

	protected final static String version = "${version}";
	public static final String modid = "beatdownstick";

	@Instance(modid)
	public static BeatDownStick instance = new BeatDownStick();

	@SidedProxy(clientSide = "Tamaized.BeatDownStick.proxy.ClientProxy", serverSide = "Tamaized.BeatDownStick.proxy.ServerProxy")
	public static AbstractProxy proxy;

	public static Logger logger;

	public static ItemRegistry items;
	public static DamageSourceRegistry damageSource;

	@Override
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("BeatDownStick");

		register(items = new ItemRegistry());
		register(damageSource = new DamageSourceRegistry());

		// Super here to start register stuff
		super.preInit(event);

		proxy.preInit();
	}

	@Override
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);

		MinecraftForge.EVENT_BUS.register(this);

		proxy.init();
	}

	@Override
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
		proxy.postInit();
	}

	@SubscribeEvent
	public void modifyLootTables(LootTableLoadEvent e) {
		if (e.getTable() == null) return;
		LootPool pool = e.getTable().getPool("main");
		if (pool == null) return;

		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON) || e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE) || e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
			pool.addEntry(new LootEntryItem(items.beatDownStick, 1, 0, new LootFunction[0], new LootCondition[0], modid + ":beatdownstick"));
			// pool.addEntry(new LootEntryItem(items.cheesyBurger, 1, 0, new LootFunction[0], new LootCondition[0], modid + ":cheesyburger"));
		}
	}

}

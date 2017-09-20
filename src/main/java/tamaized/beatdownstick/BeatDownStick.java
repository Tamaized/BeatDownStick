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
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tamaized.beatdownstick.registry.DamageSourceRegistry;
import tamaized.beatdownstick.registry.ItemRegistry;
import tamaized.tammodized.TamModBase;
import tamaized.tammodized.TamModized;
import tamaized.tammodized.proxy.AbstractProxy;

@Mod(modid = BeatDownStick.modid, name = "Beat Down Stick", version = BeatDownStick.version, dependencies = "required-before:" + TamModized.modid + "@[${tamversion},)")
public class BeatDownStick extends TamModBase {

	public static final String modid = "beatdownstick";
	public static final String version = "${version}";
	@Instance(modid)
	public static BeatDownStick instance = new BeatDownStick();

	@SidedProxy(clientSide = "tamaized.beatdownstick.proxy.ClientProxy", serverSide = "tamaized.beatdownstick.proxy.ServerProxy")
	public static AbstractProxy proxy;

	static {
		new ItemRegistry();
		new DamageSourceRegistry();
	}

	@Override
	protected AbstractProxy getProxy() {
		return proxy;
	}

	@Override
	public String getModID() {
		return modid;
	}

	@Override
	@EventHandler
	public void FMLpreInit(FMLPreInitializationEvent event) {
		super.FMLpreInit(event);
	}

	@Override
	@EventHandler
	public void FMLinit(FMLInitializationEvent event) {
		super.FMLinit(event);
	}

	@Override
	@EventHandler
	public void FMLpostInit(FMLPostInitializationEvent event) {
		super.FMLpostInit(event);
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Override
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {

	}

	@SubscribeEvent
	public void modifyLootTables(LootTableLoadEvent e) {
		if (e.getTable() == null)
			return;
		LootPool pool = e.getTable().getPool("main");
		if (pool == null)
			return;

		if (e.getName().equals(LootTableList.CHESTS_SIMPLE_DUNGEON) || e.getName().equals(LootTableList.CHESTS_JUNGLE_TEMPLE) || e.getName().equals(LootTableList.CHESTS_DESERT_PYRAMID) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CORRIDOR) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_CROSSING) || e.getName().equals(LootTableList.CHESTS_STRONGHOLD_LIBRARY)) {
			pool.addEntry(new LootEntryItem(ItemRegistry.beatDownStick, 1, 0, new LootFunction[0], new LootCondition[0], modid + ":beatdownstick"));
			// pool.addEntry(new LootEntryItem(items.cheesyBurger, 1, 0, new LootFunction[0], new LootCondition[0], modid + ":cheesyburger"));
		}
	}

}

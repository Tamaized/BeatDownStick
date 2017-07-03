package Tamaized.BeatDownStick.registry;

import Tamaized.BeatDownStick.items.ItemBeatDownStick;
import Tamaized.BeatDownStick.items.ItemSuperBeatDownStick;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tamaized.tammodized.registry.ITamRegistry;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber
public class ItemRegistry {

	public static ItemBeatDownStick beatDownStick;
	public static ItemSuperBeatDownStick superBeatDownStick;
	private static List<ITamRegistry> modelList;
	// public static ItemBeatDownStick cheesyBurger;
	// public static ItemSuperBeatDownStick superCheesyBurger;

	static {
		modelList = new ArrayList<>();

		modelList.add(beatDownStick = new ItemBeatDownStick(CreativeTabs.COMBAT, "beatdownstick", 1));
		modelList.add(superBeatDownStick = new ItemSuperBeatDownStick(CreativeTabs.COMBAT, "superbeatdownstick", 1));
		// modelList.add(cheesyBurger = new ItemBeatDownStick(CreativeTabs.COMBAT, "cheesyburger", 1));
		// modelList.add(superCheesyBurger = new ItemSuperBeatDownStick(CreativeTabs.COMBAT, "supercheesyburger", 1));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		for (ITamRegistry r : modelList)
			r.registerItem(event);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		for (ITamRegistry r : modelList)
			r.registerModel(event);
	}

}

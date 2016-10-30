package Tamaized.BeatDownStick.registry;

import java.util.ArrayList;

import Tamaized.BeatDownStick.BeatDownStick;
import Tamaized.BeatDownStick.items.ItemBeatDownStick;
import Tamaized.BeatDownStick.items.ItemCheesyBurger;
import Tamaized.BeatDownStick.items.ItemSuperBeatDownStick;
import Tamaized.BeatDownStick.items.ItemSuperCheesyBurger;
import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import net.minecraft.creativetab.CreativeTabs;

public class ItemRegistry implements ITamRegistry {

	private ArrayList<ITamModel> modelList;

	public static ItemBeatDownStick beatDownStick;
	public static ItemSuperBeatDownStick superBeatDownStick;
	public static ItemCheesyBurger cheesyBurger;
	public static ItemSuperCheesyBurger superCheesyBurger;

	@Override
	public void preInit() {
		modelList = new ArrayList<ITamModel>();

		modelList.add(beatDownStick = new ItemBeatDownStick(CreativeTabs.COMBAT, "beatDownStick", 1));
		modelList.add(superBeatDownStick = new ItemSuperBeatDownStick(CreativeTabs.COMBAT, "superBeatDownStick", 1));
		modelList.add(cheesyBurger = new ItemCheesyBurger(CreativeTabs.COMBAT, "cheesyBurger", 1));
		modelList.add(superCheesyBurger = new ItemSuperCheesyBurger(CreativeTabs.COMBAT, "superCheesyBurger", 1));
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void clientPreInit() {

	}

	@Override
	public void clientInit() {

	}

	@Override
	public void clientPostInit() {

	}

	@Override
	public ArrayList<ITamModel> getModelList() {
		return modelList;
	}

	@Override
	public String getModID() {
		return BeatDownStick.modid;
	}

}

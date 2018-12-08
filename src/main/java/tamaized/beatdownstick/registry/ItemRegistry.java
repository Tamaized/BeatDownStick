package tamaized.beatdownstick.registry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.common.items.ItemBeatDownStick;
import tamaized.beatdownstick.common.items.ItemSuperBeatDownStick;

@GameRegistry.ObjectHolder(BeatDownStick.MODID)
@Mod.EventBusSubscriber(modid = BeatDownStick.MODID)
public class ItemRegistry {

	@GameRegistry.ObjectHolder("beatdownstick")
	public static final Item beatDownStick = Items.AIR;
	@GameRegistry.ObjectHolder("superbeatdownstick")
	public static final Item superBeatDownStick = Items.AIR;
	// public static ItemBeatDownStick cheesyBurger;
	// public static ItemSuperBeatDownStick superCheesyBurger;

	static {
		// modelList.add(cheesyBurger = new ItemBeatDownStick(CreativeTabs.COMBAT, "cheesyburger", 1));
		// modelList.add(superCheesyBurger = new ItemSuperBeatDownStick(CreativeTabs.COMBAT, "supercheesyburger", 1));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(

				setupTranslation(new ItemBeatDownStick().setCreativeTab(CreativeTabs.COMBAT).setRegistryName(BeatDownStick.MODID, "beatdownstick")),

				setupTranslation(new ItemSuperBeatDownStick().setCreativeTab(CreativeTabs.COMBAT).setRegistryName(BeatDownStick.MODID, "superbeatdownstick"))

		);
	}

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event) {
		registerModels(beatDownStick, superBeatDownStick);
	}

	private static void registerModels(Item... items) {
		for (Item item : items) {
			if (item == null || item.getRegistryName() == null)
				continue;
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getNamespace(), "items/" + item.getRegistryName().getPath()), "inventory"));
		}
	}

	private static Item setupTranslation(Item item) {
		if (item.getRegistryName() == null)
			throw new NullPointerException("Registry name cannot be null");
		return item.setTranslationKey(item.getRegistryName().getNamespace() + "." + item.getRegistryName().getPath());
	}

}

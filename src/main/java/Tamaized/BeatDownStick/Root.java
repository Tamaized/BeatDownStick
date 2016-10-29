package Tamaized.BeatDownStick;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Tamaized.BeatDownStick.damageSource.DamageSourceAnnihilate;
import Tamaized.BeatDownStick.items.ItemBeatDownStick;
import Tamaized.BeatDownStick.items.ItemCheesyBurger;
import Tamaized.BeatDownStick.items.ItemSuperBeatDownStick;
import Tamaized.BeatDownStick.items.ItemSuperCheesyBurger;
import Tamaized.BeatDownStick.proxy.ServerProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Root.modid, name="Beat Down Stick", version=Root.version, dependencies = "required-before:" + TamModized.modid + "@[" + TamModized.version + ",)")

public class Root {
	
	protected final static String version = "${version}";
	public static final String modid = "BeatDownStick";
	
	@Instance(modid) 
	public static Root instance = new Root();
	
	@SidedProxy(clientSide = "Tamaized.BeatDownStick.proxy.ClientProxy", serverSide = "Tamaized.BeatDownStick.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static Logger logger;
	
	public static Item BeatDownStick;
	public static Item SuperBeatDownStick;
	public static Item CheesyBurger;
	public static Item SuperCheesyBurger;
	
	public static DamageSource dmgOp;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger = LogManager.getLogger("Beat Down Stick");
		
		dmgOp = new DamageSourceAnnihilate(modid+".annihilate").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
		
		BeatDownStick = new ItemBeatDownStick().setFull3D().setUnlocalizedName("beatDownStick").setCreativeTab(CreativeTabs.tabCombat).setTextureName("stick").setMaxStackSize(1).setMaxDamage(21);
		SuperBeatDownStick = new ItemSuperBeatDownStick().setFull3D().setUnlocalizedName("superBeatDownStick").setCreativeTab(CreativeTabs.tabCombat).setTextureName("stick").setMaxStackSize(1);
		CheesyBurger = new ItemCheesyBurger().setFull3D().setUnlocalizedName("cheesyBurger").setTextureName(modid.toLowerCase()+":yum").setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1).setMaxDamage(21);;
		SuperCheesyBurger = new ItemSuperCheesyBurger().setFull3D().setUnlocalizedName("superCheesyBurger").setTextureName(modid.toLowerCase()+":yum").setCreativeTab(CreativeTabs.tabCombat).setMaxStackSize(1);
	}
	
	@EventHandler
	public void InitVoidCraft(FMLInitializationEvent event){ 
		GameRegistry.registerItem(BeatDownStick, BeatDownStick.getUnlocalizedName());
		GameRegistry.registerItem(SuperBeatDownStick, SuperBeatDownStick.getUnlocalizedName());
		GameRegistry.registerItem(CheesyBurger, CheesyBurger.getUnlocalizedName());
		GameRegistry.registerItem(SuperCheesyBurger, SuperCheesyBurger.getUnlocalizedName());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e){ 
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(BeatDownStick), 1, 1, 2));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(BeatDownStick), 1, 1, 2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(BeatDownStick), 1, 1, 2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(BeatDownStick), 1, 1, 2));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(BeatDownStick), 1, 1, 2));
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(CheesyBurger), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.PYRAMID_JUNGLE_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(CheesyBurger), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CORRIDOR).addItem(new WeightedRandomChestContent(new ItemStack(CheesyBurger), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_CROSSING).addItem(new WeightedRandomChestContent(new ItemStack(CheesyBurger), 1, 1, 1));
		ChestGenHooks.getInfo(ChestGenHooks.STRONGHOLD_LIBRARY).addItem(new WeightedRandomChestContent(new ItemStack(CheesyBurger), 1, 1, 1));
		
		proxy.registerItems();
	}

}

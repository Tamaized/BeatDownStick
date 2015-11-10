package Tamaized.BeatDownStick.proxy;

import net.minecraft.util.EnumChatFormatting;
import Tamaized.BeatDownStick.Root;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ClientProxy extends ServerProxy{
	
	public void registerItems() {
		LanguageRegistry.addName(Root.BeatDownStick, "Beat Down Stick");
		LanguageRegistry.addName(Root.SuperBeatDownStick, EnumChatFormatting.DARK_PURPLE+"Super Beat Down Stick");
		LanguageRegistry.addName(Root.CheesyBurger, "Cheesy Burger");
		LanguageRegistry.addName(Root.SuperCheesyBurger, EnumChatFormatting.DARK_PURPLE+"Super Cheesy Burger");
	}

}

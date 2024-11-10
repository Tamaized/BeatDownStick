package tamaized.beatdownstick.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class NamespaceUtils {

	public String dot(ResourceKey<?> key) {
		return dot(key.location());
	}

	public String dot(ResourceLocation key) {
		return key.getNamespace() + "." + key.getPath();
	}

	public String slash(ResourceKey<?> key) {
		return slash(key.location());
	}

	public String slash(ResourceLocation key) {
		return key.getNamespace() + "/" + key.getPath();
	}

	public String prefixId(String text) {
		return BeatDownStick.MODID + "." + text;
	}

	public String suffixId(String text) {
		return text + "." + BeatDownStick.MODID;
	}

	public String insertId(String prefix, String suffix) {
		return prefix + "." + BeatDownStick.MODID + "." + suffix;
	}

}

package tamaized.beatdownstick.util;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class NamespaceUtils {

	public String dot(ResourceKey<?> key) {
		return dot(key.identifier());
	}

	public String dot(Identifier key) {
		return key.getNamespace() + "." + key.getPath();
	}

	public String slash(ResourceKey<?> key) {
		return slash(key.identifier());
	}

	public String slash(Identifier key) {
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

package tamaized.beatdownstick.util;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import tamaized.beanification.Component;

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

}

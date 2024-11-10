package tamaized.beatdownstick.util;

import net.minecraft.resources.ResourceKey;
import tamaized.beanification.Component;

@Component
public class DotFormat {

	public String format(ResourceKey<?> key) {
		return key.location().getNamespace() + "." + key.location().getPath();
	}

}

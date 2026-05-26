package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import tamaized.beanification.Component;
import tamaized.regutil.RegUtil;

import java.util.function.Supplier;

@Component
public class ModSounds {

	public final Supplier<SoundEvent> WHAM = RegUtil.register(Registries.SOUND_EVENT, "item.wham",
		SoundEvent::createVariableRangeEvent
	);

}

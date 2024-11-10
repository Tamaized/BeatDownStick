package tamaized.beatdownstick;

import net.neoforged.fml.common.Mod;
import tamaized.beanification.BeanContext;
import tamaized.regutil.RegUtil;

@Mod(BeatDownStick.MODID)
public class BeatDownStick {

	public static final String MODID = "beatdownstick";

	static {
		BeanContext.init();
	}

	public BeatDownStick() {
		RegUtil.setup();
	}

}

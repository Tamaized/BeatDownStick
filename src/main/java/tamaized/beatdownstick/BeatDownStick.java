package tamaized.beatdownstick;

import net.neoforged.fml.common.Mod;
import tamaized.regutil.RegUtil;

@Mod(BeatDownStick.MODID)
public class BeatDownStick {

	public static final String MODID = "beatdownstick";

	public BeatDownStick() {
		RegUtil.setup();
	}

}

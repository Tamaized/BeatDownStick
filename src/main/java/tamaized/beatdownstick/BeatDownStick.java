package tamaized.beatdownstick;

import net.neoforged.fml.common.Mod;
import tamaized.beanification.BeanContext;
import tamaized.datagenutil.DataGenUtilConstants;
import tamaized.regutil.RegUtil;

@Mod(BeatDownStick.MODID)
public class BeatDownStick {

	public static final String MODID = "beatdownstick";

	static {
		BeanContext.configure()
				.scanSettings().addAdditionalComponentScanModuleName(RegUtil.MODULE_NAME)
				.scanSettings().addAdditionalComponentScanModuleName(DataGenUtilConstants.MODULE_NAME);
		BeanContext.init(MODID);
	}

}

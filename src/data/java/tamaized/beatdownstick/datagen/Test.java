package tamaized.beatdownstick.datagen;

import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class Test {

	@PostConstruct
	private void test() {
		throw new RuntimeException("Test " + BeatDownStick.MODID);
	}

}

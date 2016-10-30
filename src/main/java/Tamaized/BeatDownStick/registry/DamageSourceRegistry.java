package Tamaized.BeatDownStick.registry;

import java.util.ArrayList;

import Tamaized.BeatDownStick.BeatDownStick;
import Tamaized.BeatDownStick.damageSource.DamageSourceAnnihilate;
import Tamaized.TamModized.registry.ITamModel;
import Tamaized.TamModized.registry.ITamRegistry;
import net.minecraft.util.DamageSource;

public class DamageSourceRegistry implements ITamRegistry {

	private ArrayList<ITamModel> modelList;

	public static DamageSource dmgOp;

	@Override
	public void preInit() {
		modelList = new ArrayList<ITamModel>();

		dmgOp = new DamageSourceAnnihilate(BeatDownStick.modid + ".annihilate").setDamageBypassesArmor().setDamageAllowedInCreativeMode();
	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void clientPreInit() {

	}

	@Override
	public void clientInit() {

	}

	@Override
	public void clientPostInit() {

	}

	@Override
	public ArrayList<ITamModel> getModelList() {
		return modelList;
	}

	@Override
	public String getModID() {
		return BeatDownStick.modid;
	}

}

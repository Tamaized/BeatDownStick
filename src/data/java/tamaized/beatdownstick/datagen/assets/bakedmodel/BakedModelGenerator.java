package tamaized.beatdownstick.datagen.assets.bakedmodel;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.datagenutil.assets.bakedmodel.item.ItemModelProviderFactory;

@Component
public class BakedModelGenerator {

	@Autowired
	private ItemModelProviderFactory itemModelProviderFactory;

	public void generate(GatherDataEvent.Client event) {
		event.getGenerator().addProvider(true, new ModelProvider(
			event.getGenerator().getPackOutput(),
			BeatDownStick.MODID
		) {
			@Override
			protected void registerModels(BlockModelGenerators blockGenerators, ItemModelGenerators itemGenerators) {
				itemModelProviderFactory.make(itemGenerators);
			}
		});
	}

}

package tamaized.beatdownstick.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class DamageTypeTagProvider {

	@Autowired
	private RegistryProvider registryProvider;

	public TagsProvider<DamageType> make(GatherDataEvent event) {
		return new TagsProvider<>(
			event.getGenerator().getPackOutput(),
			Registries.DAMAGE_TYPE,
			registryProvider.retrieve(event),
			BeatDownStick.MODID,
			event.getExistingFileHelper()
		) {
			@Override
			protected void addTags(HolderLookup.Provider provider) {

			}
		};
	}

}

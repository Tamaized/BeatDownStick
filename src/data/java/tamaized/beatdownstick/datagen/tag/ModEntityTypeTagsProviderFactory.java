package tamaized.beatdownstick.datagen.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.datagen.RegistryProvider;
import tamaized.beatdownstick.registry.ModTags;

@Component
public class ModEntityTypeTagsProviderFactory {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private ModTags tags;

	public TagsProvider<EntityType<?>> make(GatherDataEvent event) {
		return new EntityTypeTagsProvider(
			event.getGenerator().getPackOutput(),
			registryProvider.retrieve(event),
			BeatDownStick.MODID,
			event.getExistingFileHelper()
		) {
			@Override
			protected void addTags(HolderLookup.Provider provider) {
				tag(tags.DONT_ONE_SHOT).addTag(Tags.EntityTypes.BOSSES).add(EntityType.WARDEN);
			}
		};
	}

}

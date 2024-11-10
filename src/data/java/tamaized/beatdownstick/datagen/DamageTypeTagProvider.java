package tamaized.beatdownstick.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.registry.ModDamageTypes;

@Component
public class DamageTypeTagProvider {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private ModDamageTypes damageTypes;

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
				tag(damageTypes.ANNIHILATE, DamageTypeTags.BYPASSES_ARMOR, DamageTypeTags.BYPASSES_ENCHANTMENTS, DamageTypeTags.BYPASSES_INVULNERABILITY);
			}

			@SafeVarargs
			private void tag(ResourceKey<DamageType> type, TagKey<DamageType>... tags) {
				for (TagKey<DamageType> key : tags) {
					tag(key).add(type);
				}
			}
		};
	}

}

package tamaized.beatdownstick.datagen.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.datagen.RegistryProvider;
import tamaized.beatdownstick.datagen.util.TagProviderUtil;
import tamaized.beatdownstick.registry.ModDamageTypes;

@Component
public class DamageTypeTagProviderFactory {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private ModDamageTypes damageTypes;

	@Autowired
	private TagProviderUtil tagProviderUtil;

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
				tagProviderUtil.tagMany(this::tag, damageTypes.ANNIHILATE, DamageTypeTags.BYPASSES_ARMOR, DamageTypeTags.BYPASSES_ENCHANTMENTS, DamageTypeTags.BYPASSES_INVULNERABILITY);
			}
		};
	}

}

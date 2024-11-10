package tamaized.beatdownstick.datagen.lang;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.datagen.RegistryProvider;
import tamaized.beatdownstick.datagen.util.TagProviderUtil;
import tamaized.beatdownstick.registry.ModDamageTypes;
import tamaized.beatdownstick.registry.ModItems;
import tamaized.beatdownstick.registry.ModSounds;
import tamaized.beatdownstick.util.NamespaceUtils;

@Component
public class LangProviderFactory {

	@Autowired
	private RegistryProvider registryProvider;

	@Autowired
	private NamespaceUtils namespaceUtils;

	@Autowired
	private ModItems items;

	@Autowired
	private ModDamageTypes damageTypes;

	@Autowired
	private ModSounds sounds;

	public LanguageProvider make(GatherDataEvent event) {
		return new LanguageProvider(
			event.getGenerator().getPackOutput(),
			BeatDownStick.MODID,
			Language.DEFAULT
		) {
			@Override
			protected void addTranslations() {
				add(items.BEAT_DOWN_STICK.get(), "Beat Down Stick");
				add(items.SUPER_BEAT_DOWN_STICK.get(), "§5Super Beat Down Stick§r");

				addDeathMessage(damageTypes.ANNIHILATE, "%s was annihilated");

				addSubtitle(sounds.WHAM.get(), "Stick smacks");
			}

			private void addDeathMessage(ResourceKey<DamageType> key, String translation) {
				add(key.location().toLanguageKey("death.attack"), translation);
			}

			private void addSubtitle(SoundEvent key, String translation) {
				add(key.getLocation().toLanguageKey("subtitles"), translation);
			}
		};
	}

}

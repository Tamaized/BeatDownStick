package tamaized.beatdownstick.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Autowired;
import tamaized.beanification.Component;
import tamaized.beanification.PostConstruct;
import tamaized.beatdownstick.BeatDownStick;
import tamaized.beatdownstick.datagen.bootstrap.DamageTypeBootstrap;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

@Component
public class RegistryProvider {

	@Autowired
	private DamageTypeBootstrap damageTypeBootstrap;

	private RegistrySetBuilder builder = new RegistrySetBuilder();
	private DatapackBuiltinEntriesProvider value;

	@PostConstruct
	private void setup() {
		builder = damageTypeBootstrap.bootstrap(builder);

	}

	public CompletableFuture<HolderLookup.Provider> retrieve(GatherDataEvent event) {
		if (value == null) {
			value = new DatapackBuiltinEntriesProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), builder, Set.of("minecraft", BeatDownStick.MODID));
			event.getGenerator().addProvider(event.includeServer(), value);
		}
		return value.getRegistryProvider();
	}

}

package tamaized.beatdownstick.datagen.generator;

import net.minecraft.DetectedVersion;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tamaized.beanification.Component;

import java.util.Optional;

@Component
public class MetadataGenerator {

	public void generate(GatherDataEvent event) {
		event.getGenerator().addProvider(true, new PackMetadataGenerator(event.getGenerator().getPackOutput())
			.add(PackMetadataSection.TYPE, new PackMetadataSection(
					net.minecraft.network.chat.Component.literal("Resources for BeatDownStick"),
					DetectedVersion.BUILT_IN.getPackVersion(PackType.SERVER_DATA),
					Optional.of(new InclusiveRange<>(0, Integer.MAX_VALUE))
				)
			)
		);
	}

}

package tamaized.beatdownstick.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import tamaized.beanification.Component;
import tamaized.beatdownstick.BeatDownStick;

@Component
public class ModTags {

	public final TagKey<EntityType<?>> DONT_ONE_SHOT = TagKey.create(Registries.ENTITY_TYPE,
		Identifier.fromNamespaceAndPath(BeatDownStick.MODID, "stick_doesnt_one_shot")
	);

}

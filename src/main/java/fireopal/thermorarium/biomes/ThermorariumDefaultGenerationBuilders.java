package fireopal.thermorarium.biomes;

import fireopal.thermorarium.util.FireopalBiomeAPI_v1;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.GenerationStep;

public class ThermorariumDefaultGenerationBuilders {
    public static void addDefaultNetherForestFeatures(GenerationSettings.Builder generationSettings) {
        ConfiguredFeature<?, ?>[] undergroundDecorFeatures = {
            ConfiguredFeatures.SPRING_OPEN,
            ConfiguredFeatures.PATCH_FIRE,
            ConfiguredFeatures.GLOWSTONE_EXTRA,
            ConfiguredFeatures.GLOWSTONE,
            ConfiguredFeatures.ORE_MAGMA,
            ConfiguredFeatures.SPRING_CLOSED
        };

        FireopalBiomeAPI_v1.addFeatures(generationSettings, GenerationStep.Feature.UNDERGROUND_DECORATION, undergroundDecorFeatures);
    }
}

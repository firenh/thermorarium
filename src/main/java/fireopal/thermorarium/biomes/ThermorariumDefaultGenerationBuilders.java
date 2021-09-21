package fireopal.thermorarium.biomes;

import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Generation;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;

public class ThermorariumDefaultGenerationBuilders {
    public static void addDefaultNetherForestFeatures(GenerationSettings.Builder generationSettings) {
        Generation.undergroundDecorationFeatures(generationSettings,
            ConfiguredFeatures.SPRING_OPEN,
            ConfiguredFeatures.PATCH_FIRE,
            ConfiguredFeatures.GLOWSTONE_EXTRA,
            ConfiguredFeatures.GLOWSTONE,
            ConfiguredFeatures.ORE_MAGMA,
            ConfiguredFeatures.SPRING_CLOSED
        );

        Generation.vegetalDecorationFeatures(generationSettings,
            ConfiguredFeatures.SPRING_LAVA
        );

        DefaultBiomeFeatures.addNetherMineables(generationSettings);
    }

    public static void addDefaultNetherCarvers(GenerationSettings.Builder generationSettings) {
        Generation.airCarver(generationSettings,
            ConfiguredCarvers.NETHER_CAVE
        );
    }

    public static void addDefaultNetherStructures(GenerationSettings.Builder generationSettings) {
        addDefaultNetherStructuresNoBastion(generationSettings);
        Generation.structureFeatures(generationSettings, ConfiguredStructureFeatures.BASTION_REMNANT);
    }

    public static void addDefaultNetherStructuresNoBastion(Builder generationSettings) {
        Generation.structureFeatures(generationSettings,
            ConfiguredStructureFeatures.RUINED_PORTAL_NETHER,
            ConfiguredStructureFeatures.FORTRESS
        );
    }
}

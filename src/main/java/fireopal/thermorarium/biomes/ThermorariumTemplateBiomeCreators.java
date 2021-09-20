package fireopal.thermorarium.biomes;

import net.minecraft.world.biome.GenerationSettings;
import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.ConfiguredStructureFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;


public class ThermorariumTemplateBiomeCreators {
    public static Biome createNetherForestBiome(SpawnSettings.SpawnEntry[] monsters, SpawnSettings.SpawnEntry[] creatures) {
        //SpawnSettings

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        FireopalBiomeAPI_v1.addMonsters(spawnSettings, monsters);
        FireopalBiomeAPI_v1.addCreatures(spawnSettings, creatures);

        //GenerationSettings

        ConfiguredFeature<?, ?>[] undergroundDecorFeatures = {
            ConfiguredFeatures.SPRING_OPEN,
            ConfiguredFeatures.PATCH_FIRE,
            ConfiguredFeatures.GLOWSTONE_EXTRA,
            ConfiguredFeatures.GLOWSTONE,
            ConfiguredFeatures.ORE_MAGMA,
            ConfiguredFeatures.SPRING_CLOSED
        };


        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(ConfiguredSurfaceBuilders.CRIMSON_FOREST)
            .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
            .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
            .structureFeature(ConfiguredStructureFeatures.FORTRESS)
            .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        FireopalBiomeAPI_v1.addFeatures(generationSettings, GenerationStep.Feature.UNDERGROUND_DECORATION, undergroundDecorFeatures);

        return (new Biome.Builder())
            .precipitation(Biome.Precipitation.NONE)
            .category(Biome.Category.NETHER)
            .depth(0.1F)
            .scale(0.2F)
            .temperature(2.0F)
            .downfall(0.0F)
            .effects((new BiomeEffects.Builder())
                .waterColor(4159204)
                .waterFogColor(329011)
                .fogColor(3343107)
                .skyColor(3343107)
                .particleConfig(new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025F))
                .loopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST))
                .build())
            .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}

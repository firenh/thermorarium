package fireopal.thermorarium.biomes;

import net.minecraft.world.biome.GenerationSettings;
import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Spawns;
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

public class ThermorariumBiomeCreators {
    static SpawnSettings.SpawnEntry spawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        return Spawns.spawn(type, weight, minGroupSize, maxGroupSize);
    }

    public static Biome createCrimonPlains() {
        //SpawnSettings

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        SpawnSettings.SpawnEntry[] monsters = {
            spawn(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4), 
            spawn(EntityType.HOGLIN, 9, 3, 4),
            spawn(EntityType.PIGLIN, 5, 3, 4)
        };

        SpawnSettings.SpawnEntry[] creatures = {
            spawn(EntityType.STRIDER, 60, 1, 2)
        };

        Spawns.monsters(spawnSettings, monsters);
        Spawns.creatures(spawnSettings, creatures);

        //GenerationSettings

        ConfiguredFeature<?, ?>[] vegetalDecorFeatures = {
            ConfiguredFeatures.WEEPING_VINES,
            ThermorariumConfiguredFeatures.SPARSE_CRIMSON_FUNGI,
            ConfiguredFeatures.CRIMSON_FOREST_VEGETATION
        };

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(ConfiguredSurfaceBuilders.CRIMSON_FOREST)
            .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
            .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
            .structureFeature(ConfiguredStructureFeatures.FORTRESS)
            .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        ThermorariumDefaultGenerationBuilders.addDefaultNetherForestFeatures(generationSettings);
        FireopalBiomeAPI_v1.addFeatures(generationSettings, GenerationStep.Feature.VEGETAL_DECORATION, vegetalDecorFeatures);

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

    public static Biome createWarpedPlains() {
        //SpawnSettings

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        SpawnSettings.SpawnEntry[] monsters = {
            spawn(EntityType.ENDERMAN, 1, 4, 4)
        };

        SpawnSettings.SpawnEntry[] creatures = {
            spawn(EntityType.STRIDER, 60, 1, 2)
        };

        Spawns.monsters(spawnSettings, monsters);
        Spawns.creatures(spawnSettings, creatures);
        spawnSettings.spawnCost(EntityType.ENDERMAN, 1.0D, 0.12D);

        //GenerationSettings

        ConfiguredFeature<?, ?>[] vegetalDecorFeatures = {
            ThermorariumConfiguredFeatures.SPARSE_WARPED_FUNGI,
            ConfiguredFeatures.WARPED_FOREST_VEGETATION
        };

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(ConfiguredSurfaceBuilders.WARPED_FOREST)
            .structureFeature(ConfiguredStructureFeatures.RUINED_PORTAL_NETHER)
            .carver(GenerationStep.Carver.AIR, ConfiguredCarvers.NETHER_CAVE)
            .structureFeature(ConfiguredStructureFeatures.FORTRESS)
            .structureFeature(ConfiguredStructureFeatures.BASTION_REMNANT)
            .feature(GenerationStep.Feature.VEGETAL_DECORATION, ConfiguredFeatures.SPRING_LAVA);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        ThermorariumDefaultGenerationBuilders.addDefaultNetherForestFeatures(generationSettings);
        FireopalBiomeAPI_v1.addFeatures(generationSettings, GenerationStep.Feature.VEGETAL_DECORATION, vegetalDecorFeatures);

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
                .fogColor(1705242)
                .skyColor(1705242)
                .particleConfig(new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F))
                .loopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                .moodSound(new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .additionsSound(new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
                .music(MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_WARPED_FOREST)).build())
            .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}

package fireopal.thermorarium.biomes;

import net.minecraft.world.biome.GenerationSettings;

import java.util.ArrayList;
import java.util.Collections;

import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Generation;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Spawns;
import net.minecraft.client.sound.MusicType;
import net.minecraft.entity.EntityType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BiomeAdditionsSound;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.BiomeParticleConfig;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class ThermorariumBiomeCreators {
    public static final int crimsonFogColor = 3343107;
    public static final int warpedFogColor = 1705242;

    public static final BiomeParticleConfig crimsonParticles = new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025F);
    public static final BiomeParticleConfig warpedParticles = new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F);

    public static final SoundEvent ambientCrimsonLoop = SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP;
    public static final BiomeMoodSound ambientCrimsonMood = new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D);
    public static final BiomeAdditionsSound ambientCrimsonAdditions = new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D);
    public static final MusicSound crimsonMusic = MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST);

    public static final SoundEvent ambientWarpedLoop = SoundEvents.AMBIENT_WARPED_FOREST_LOOP;
    public static final BiomeMoodSound ambientWarpedMood = new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D);
    public static final BiomeAdditionsSound ambientWarpedAdditions = new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D);
    public static final MusicSound warpedMusic = MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_WARPED_FOREST);

    public static final ConfiguredSurfaceBuilder<?> crimsonSurfaceBuilder = ConfiguredSurfaceBuilders.CRIMSON_FOREST;
    public static final ConfiguredSurfaceBuilder<?> warpedSurfaceBuilder = ConfiguredSurfaceBuilders.WARPED_FOREST;

    static SpawnSettings.SpawnEntry spawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        return Spawns.spawn(type, weight, minGroupSize, maxGroupSize);
    }

    public static Biome createNetherPlainsBiome(boolean crimson) {
        ConfiguredSurfaceBuilder<?> surfaceBuilder;

        int fogColor = 0;
        BiomeParticleConfig particles;
        SoundEvent ambientLoop;
        BiomeMoodSound ambientMood;
        BiomeAdditionsSound ambientAdditions;
        MusicSound music;

        ArrayList<ConfiguredFeature<?, ?>> vegetalFeatures = new ArrayList<ConfiguredFeature<?, ?>>();

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        if (crimson) {
            Spawns.monsters(spawnSettings, 
                spawn(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4), 
                spawn(EntityType.HOGLIN, 9, 3, 4),
                spawn(EntityType.PIGLIN, 5, 3, 4)
            );

            surfaceBuilder = crimsonSurfaceBuilder;

            fogColor = crimsonFogColor;
            particles = crimsonParticles;

            ambientLoop = ambientCrimsonLoop;
            ambientMood = ambientCrimsonMood;
            ambientAdditions = ambientCrimsonAdditions;
            music = crimsonMusic;

            Collections.addAll(vegetalFeatures, 
                ConfiguredFeatures.WEEPING_VINES,
                ThermorariumConfiguredFeatures.SPARSE_CRIMSON_FUNGI,
                ConfiguredFeatures.CRIMSON_FOREST_VEGETATION
            );
        } else {
            Spawns.monsters(spawnSettings, 
                spawn(EntityType.ENDERMAN, 1, 4, 4)
            );
            Spawns.cost(spawnSettings,
                Spawns.spawnCost(EntityType.ENDERMAN, 1.0D, 0.12D)
            );

            surfaceBuilder = warpedSurfaceBuilder;

            fogColor = warpedFogColor;
            particles = warpedParticles;

            ambientLoop = ambientWarpedLoop;
            ambientMood = ambientWarpedMood;
            ambientAdditions = ambientWarpedAdditions;
            music = warpedMusic;

            Collections.addAll(vegetalFeatures, 
            ThermorariumConfiguredFeatures.SPARSE_WARPED_FUNGI,
                ConfiguredFeatures.WARPED_FOREST_VEGETATION
            );
        }

        Spawns.creatures(spawnSettings,
            spawn(EntityType.STRIDER, 60, 1, 2)
        );

        //GenerationSettings

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(surfaceBuilder);
        ThermorariumDefaultGenerationBuilders.addDefaultNetherCarvers(generationSettings);
        ThermorariumDefaultGenerationBuilders.addDefaultNetherStructures(generationSettings);
        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        ThermorariumDefaultGenerationBuilders.addDefaultNetherForestFeatures(generationSettings);

        ConfiguredFeature<?, ?>[] vegetalFeatures2 = new ConfiguredFeature<?, ?>[vegetalFeatures.size()];
        vegetalFeatures2 = vegetalFeatures.toArray(vegetalFeatures2);
        
        Generation.vegetalDecorationFeatures(generationSettings, vegetalFeatures2);

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
                .fogColor(fogColor)
                .skyColor(fogColor)
                .particleConfig(particles)
                .loopSound(ambientLoop)
                .moodSound(ambientMood)
                .additionsSound(ambientAdditions)
                .music(music)
                .build())
            .spawnSettings(spawnSettings.build()).generationSettings(generationSettings.build()).build();
    }
}

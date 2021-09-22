package fireopal.thermorarium.biomes;

import net.minecraft.world.biome.GenerationSettings;

import java.util.ArrayList;
import java.util.Collections;

import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Build;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Effects;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Generation;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Spawns;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Effects.BiomeSounds;
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
import net.minecraft.world.gen.GenerationStep;
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

    public static Biome createNetherForestTypeBiome(boolean crimson, boolean marsh) {
        ConfiguredSurfaceBuilder<?> surfaceBuilder;

        int fogColor = 0;
        BiomeParticleConfig particles;
        BiomeSounds biomeSounds;

        ArrayList<ConfiguredFeature<?, ?>> surfaceStructureFeatures = new ArrayList<ConfiguredFeature<?, ?>>();
        ArrayList<ConfiguredFeature<?, ?>> vegetalFeatures = new ArrayList<ConfiguredFeature<?, ?>>();
        ArrayList<ConfiguredFeature<?, ?>> undergroundDecorFeatures = new ArrayList<ConfiguredFeature<?, ?>>();

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

            biomeSounds = new BiomeSounds(ambientCrimsonLoop, ambientCrimsonMood, ambientCrimsonAdditions, crimsonMusic);

            Collections.addAll(vegetalFeatures, 
                ConfiguredFeatures.WEEPING_VINES,
                ConfiguredFeatures.CRIMSON_FOREST_VEGETATION
            );

            if (marsh) {
                Collections.addAll(vegetalFeatures,
                    ConfiguredFeatures.CRIMSON_FUNGI
                );
                Collections.addAll(undergroundDecorFeatures,
                    ThermorariumConfiguredFeatures.MAGMA_TO_CRIMSON,
                    ThermorariumConfiguredFeatures.MAGMA_TO_LAVA
                );
                Collections.addAll(surfaceStructureFeatures,
                    ConfiguredFeatures.SMALL_BASALT_COLUMNS,
                    ThermorariumConfiguredFeatures.CRIMSON_MARSH_DELTA
                );
            } else {
                vegetalFeatures.add(ThermorariumConfiguredFeatures.SPARSE_CRIMSON_FUNGI);
            }
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

            biomeSounds = new BiomeSounds(ambientWarpedLoop, ambientWarpedMood, ambientWarpedAdditions, warpedMusic);

            Collections.addAll(vegetalFeatures,
                ConfiguredFeatures.WARPED_FOREST_VEGETATION
            );

            if (marsh) {
                Collections.addAll(vegetalFeatures,
                    ConfiguredFeatures.WARPED_FUNGI
                );
                Collections.addAll(undergroundDecorFeatures,
                    ThermorariumConfiguredFeatures.MAGMA_TO_WARPED,
                    ThermorariumConfiguredFeatures.MAGMA_TO_LAVA
                );
                Collections.addAll(surfaceStructureFeatures,
                    ConfiguredFeatures.SMALL_BASALT_COLUMNS,
                    ThermorariumConfiguredFeatures.WARPED_MARSH_DELTA
                );
            } else {
                vegetalFeatures.add(ThermorariumConfiguredFeatures.SPARSE_WARPED_FUNGI);
            }
        }

        Spawns.creatures(spawnSettings,
            spawn(EntityType.STRIDER, 60, 1, 2)
        );

        //GenerationSettings

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(surfaceBuilder);

        Generation.features(generationSettings, GenerationStep.Feature.SURFACE_STRUCTURES, surfaceStructureFeatures);
        Generation.features(generationSettings, GenerationStep.Feature.UNDERGROUND_DECORATION, undergroundDecorFeatures);
        Generation.features(generationSettings, GenerationStep.Feature.VEGETAL_DECORATION, vegetalFeatures);

        ThermorariumDefaultGenerationBuilders.addNetherForestStuff(generationSettings);
        
        

        BiomeEffects.Builder biomeEffects = ((new BiomeEffects.Builder())
            .waterColor(4159204)
            .waterFogColor(329011)
            .fogColor(fogColor)
            .skyColor(fogColor)
            .particleConfig(particles));
        Effects.addBiomeSounds(biomeEffects, biomeSounds);

        Biome.Builder biome = (new Biome.Builder())
        .precipitation(Biome.Precipitation.NONE)
        .category(Biome.Category.NETHER);
        Build.properties(biome, 0.1F, 0.2F, 2.0F, 0.0F);
        Build.finalize(biome, spawnSettings, generationSettings, biomeEffects);

        return biome.build();
    }
}

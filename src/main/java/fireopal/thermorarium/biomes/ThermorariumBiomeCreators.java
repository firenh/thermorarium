package fireopal.thermorarium.biomes;

import net.minecraft.world.biome.GenerationSettings;

import java.util.ArrayList;
import java.util.Collections;

import fireopal.thermorarium.features.ThermorariumConfiguredFeatures;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Build;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Effects;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.Generation;
import fireopal.thermorarium.util.FireopalBiomeAPI_v1.ObjectSwap;
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
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilders;

public class ThermorariumBiomeCreators {

    private static final int crimsonFogColor = 3343107;
    private static final int warpedFogColor = 1705242;
    private static final ObjectSwap<Integer> wartForestSkyColor = new ObjectSwap<Integer>(crimsonFogColor, warpedFogColor);

    private static final BiomeParticleConfig crimsonParticles = new BiomeParticleConfig(ParticleTypes.CRIMSON_SPORE, 0.025F);
    private static final BiomeParticleConfig warpedParticles = new BiomeParticleConfig(ParticleTypes.WARPED_SPORE, 0.01428F);
    private static final ObjectSwap<BiomeParticleConfig> wartForestParticles = new ObjectSwap<BiomeParticleConfig>(crimsonParticles, warpedParticles); 

    private static final SoundEvent ambientCrimsonLoop = SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP;
    private static final BiomeMoodSound ambientCrimsonMood = new BiomeMoodSound(SoundEvents.AMBIENT_CRIMSON_FOREST_MOOD, 6000, 8, 2.0D);
    private static final BiomeAdditionsSound ambientCrimsonAdditions = new BiomeAdditionsSound(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D);
    private static final MusicSound crimsonMusic = MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_CRIMSON_FOREST);
    private static final BiomeSounds crimsonBiomeSounds = new BiomeSounds(ambientCrimsonLoop, ambientCrimsonMood, ambientCrimsonAdditions, crimsonMusic);

    private static final SoundEvent ambientWarpedLoop = SoundEvents.AMBIENT_WARPED_FOREST_LOOP;
    private static final BiomeMoodSound ambientWarpedMood = new BiomeMoodSound(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D);
    private static final BiomeAdditionsSound ambientWarpedAdditions = new BiomeAdditionsSound(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D);
    private static final MusicSound warpedMusic = MusicType.createIngameMusic(SoundEvents.MUSIC_NETHER_WARPED_FOREST);
    private static final BiomeSounds warpedBiomeSounds = new BiomeSounds(ambientWarpedLoop, ambientWarpedMood, ambientWarpedAdditions, warpedMusic);

    private static final ObjectSwap<BiomeSounds> wartForestSounds = new ObjectSwap<BiomeSounds>(crimsonBiomeSounds, warpedBiomeSounds); 

    private static final ConfiguredSurfaceBuilder<?> crimsonSurfaceBuilder = ConfiguredSurfaceBuilders.CRIMSON_FOREST;
    private static final ConfiguredSurfaceBuilder<?> warpedSurfaceBuilder = ConfiguredSurfaceBuilders.WARPED_FOREST;
    
    private static final ObjectSwap<ConfiguredSurfaceBuilder<?>> wartForestSurface = new ObjectSwap<ConfiguredSurfaceBuilder<?>>(crimsonSurfaceBuilder, warpedSurfaceBuilder);

    private static final ObjectSwap<ConfiguredFeature<?, ?>> hugeFungi = new ObjectSwap<ConfiguredFeature<?, ?>>(ConfiguredFeatures.CRIMSON_FUNGI, ConfiguredFeatures.WARPED_FUNGI);
    private static final ObjectSwap<ConfiguredFeature<?, ?>> sparseHugeFungi = new ObjectSwap<ConfiguredFeature<?, ?>>(ThermorariumConfiguredFeatures.SPARSE_CRIMSON_FUNGI, ThermorariumConfiguredFeatures.SPARSE_WARPED_FUNGI);
    private static final ObjectSwap<ConfiguredFeature<?, ?>> marshDelta = new ObjectSwap<ConfiguredFeature<?, ?>>(ThermorariumConfiguredFeatures.CRIMSON_MARSH_DELTA, ThermorariumConfiguredFeatures.WARPED_MARSH_DELTA);
    private static final ObjectSwap<ConfiguredFeature<?, ?>> magmaToNyliumPeppers = new ObjectSwap<ConfiguredFeature<?, ?>>(ThermorariumConfiguredFeatures.MAGMA_TO_CRIMSON, ThermorariumConfiguredFeatures.MAGMA_TO_WARPED);
    private static final ObjectSwap<ConfiguredFeature<?, ?>> wartForestVegetation = new ObjectSwap<ConfiguredFeature<?, ?>>(ConfiguredFeatures.CRIMSON_FOREST_VEGETATION, ConfiguredFeatures.WARPED_FOREST_VEGETATION);
    private static final ObjectSwap<ConfiguredFeature<?, ?>> wartForestVines = new ObjectSwap<ConfiguredFeature<?, ?>>(ConfiguredFeatures.WEEPING_VINES, ConfiguredFeatures.TWISTING_VINES);

    static SpawnSettings.SpawnEntry spawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        return Spawns.spawn(type, weight, minGroupSize, maxGroupSize);
    }

    static void crimsonSpawns(SpawnSettings.Builder spawnSettings) {
        Spawns.monsters(spawnSettings, 
                spawn(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4), 
                spawn(EntityType.HOGLIN, 9, 3, 4),
                spawn(EntityType.PIGLIN, 5, 3, 4)
        );
    }

    static void warpedSpawns(SpawnSettings.Builder spawnSettings) {
        Spawns.monsters(spawnSettings, 
            spawn(EntityType.ENDERMAN, 1, 4, 4)
        );
        Spawns.cost(spawnSettings,
            Spawns.spawnCost(EntityType.ENDERMAN, 1.0D, 0.12D)
        );
    }

    static void wartForestSpawns(SpawnSettings.Builder spawnSettings, boolean crimson) {
        if (crimson) {
            crimsonSpawns(spawnSettings);
        } else {
            warpedSpawns(spawnSettings);
        }
    }

    public static Biome createNetherForestTypeBiome(boolean crimson, boolean marsh) {
        ArrayList<ConfiguredFeature<?, ?>> surfaceStructureFeatures = new ArrayList<ConfiguredFeature<?, ?>>();
        ArrayList<ConfiguredFeature<?, ?>> vegetalFeatures = new ArrayList<ConfiguredFeature<?, ?>>();
        ArrayList<ConfiguredFeature<?, ?>> strongholdFeatures = new ArrayList<ConfiguredFeature<?, ?>>();

        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();

        wartForestSpawns(spawnSettings, crimson);

        if (marsh) {
            Collections.addAll(vegetalFeatures,
                hugeFungi.get(crimson)
            );
            Collections.addAll(strongholdFeatures,
                magmaToNyliumPeppers.get(crimson),
                ThermorariumConfiguredFeatures.MAGMA_TO_LAVA
            );
            Collections.addAll(surfaceStructureFeatures,
                ConfiguredFeatures.SMALL_BASALT_COLUMNS,
                marshDelta.get(crimson)
            );
        } else {
            vegetalFeatures.add(sparseHugeFungi.get(crimson));
        }

        Collections.addAll(vegetalFeatures,
            wartForestVegetation.get(crimson),
            wartForestVines.get(crimson)
        );

        Spawns.creatures(spawnSettings,
            spawn(EntityType.STRIDER, 60, 1, 2)
        );

        //GenerationSettings

        GenerationSettings.Builder generationSettings = (new GenerationSettings.Builder())
            .surfaceBuilder(wartForestSurface.get(crimson));

        Generation.features(generationSettings, GenerationStep.Feature.SURFACE_STRUCTURES, surfaceStructureFeatures);
        Generation.features(generationSettings, GenerationStep.Feature.STRONGHOLDS, strongholdFeatures);
        Generation.features(generationSettings, GenerationStep.Feature.VEGETAL_DECORATION, vegetalFeatures);

        ThermorariumDefaultGenerationBuilders.addNetherForestStuff(generationSettings);
        

        int fogColor = wartForestSkyColor.get(crimson);

        BiomeEffects.Builder biomeEffects = ((new BiomeEffects.Builder())
            .waterColor(4159204)
            .waterFogColor(329011)
            .fogColor(fogColor)
            .skyColor(fogColor)
            .particleConfig(wartForestParticles.get(crimson)));
        Effects.addBiomeSounds(biomeEffects, wartForestSounds.get(crimson));

        Biome.Builder biome = (new Biome.Builder())
        .precipitation(Biome.Precipitation.NONE)
        .category(Biome.Category.NETHER);
        Build.properties(biome, 0.1F, 0.2F, 2.0F, 0.0F);
        Build.finalize(biome, spawnSettings, generationSettings, biomeEffects);

        return biome.build();
    }
}

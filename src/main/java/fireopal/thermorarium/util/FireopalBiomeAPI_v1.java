package fireopal.thermorarium.util;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class FireopalBiomeAPI_v1 {
    //SpawnSettings

    public static void addSpawnables(SpawnSettings.Builder spawnSettings, SpawnGroup spawnGroup, SpawnEntry[] spawnEntries) {
        for(SpawnEntry s : spawnEntries) {
            spawnSettings.spawn(SpawnGroup.CREATURE, s);
        }
    }

    public static void addMonsters(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
        addSpawnables(spawnSettings, SpawnGroup.MONSTER, spawnEntries);
    }

    public static void addCreatures(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
        addSpawnables(spawnSettings, SpawnGroup.CREATURE, spawnEntries);
    }

    public static SpawnEntry spawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
        return new SpawnSettings.SpawnEntry(type, weight, minGroupSize, maxGroupSize);
    }

    //GenerationSettings
    
    public static void addFeatures(GenerationSettings.Builder generationSettings, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?>[] configuredFeatures) {
        for (ConfiguredFeature<?, ?> c : configuredFeatures) {
            generationSettings.feature(featureStep, c);
        }
    }
}

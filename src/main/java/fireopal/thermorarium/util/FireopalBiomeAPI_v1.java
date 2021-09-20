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

    public class Spawns {

        //Adds in spawn entries from an array to a specific spawn group to a SpawnSettings.Builder variable
        public static void spawn(SpawnSettings.Builder spawnSettings, SpawnGroup spawnGroup, SpawnEntry[] spawnEntries) {
            for(SpawnEntry s : spawnEntries) {
                spawnSettings.spawn(SpawnGroup.CREATURE, s);
            }
        }
    
        //Calls FireopalBiomeAPI_v1.Spawns.spawn for preset spawn groups. 
        public static void ambients(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.AMBIENT, spawnEntries);
        }

        public static void creatures(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.CREATURE, spawnEntries);
        }

        public static void misc(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.MISC, spawnEntries);
        }

        public static void undergroundWaterCreatures(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.UNDERGROUND_WATER_CREATURE, spawnEntries);
        }
    
        public static void monsters(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.MONSTER, spawnEntries);
        }

        public static void waterAmbients(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.WATER_AMBIENT, spawnEntries);
        }

        public static void waterCreatures(SpawnSettings.Builder spawnSettings, SpawnEntry[] spawnEntries) {
            spawn(spawnSettings, SpawnGroup.WATER_CREATURE, spawnEntries);
        }

        public static SpawnEntry spawn(EntityType<?> type, int weight, int minGroupSize, int maxGroupSize) {
            return new SpawnSettings.SpawnEntry(type, weight, minGroupSize, maxGroupSize);
        }

        //Adds spawn costs from an array
        public static void spawnCosts(SpawnSettings.Builder spawnSettings, EntityType<?>[] entityTypes, double mass, double gravityLimit) {
            for(EntityType<?> s : entityTypes) {
                spawnSettings.spawnCost(s, mass, gravityLimit);
            }
        }
    }

    //GenerationSettings
    
    public static void addFeatures(GenerationSettings.Builder generationSettings, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?>[] configuredFeatures) {
        for (ConfiguredFeature<?, ?> c : configuredFeatures) {
            generationSettings.feature(featureStep, c);
        }
    }
}

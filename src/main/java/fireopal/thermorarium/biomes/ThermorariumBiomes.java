package fireopal.thermorarium.biomes;

import net.fabricmc.fabric.api.biome.v1.NetherBiomes;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ThermorariumBiomes {
    private static Biome register(RegistryKey<Biome> key, Biome biome) {
        return Registry.register(BuiltinRegistries.BIOME, key.getValue(), biome);
    }

    private static void add(RegistryKey<Biome> biome, float temperature, float humidity, float altitude, float weirdness, float offset) {
        NetherBiomes.addNetherBiome(biome, new Biome.MixedNoisePoint(temperature, humidity, altitude, -weirdness, offset));
    }

    public static void init() {
        register(ThermorariumBiomeKeys.CRIMSON_PLAINS, ThermorariumBiomeCreators.createNetherForestTypeBiome(true, false));
        register(ThermorariumBiomeKeys.WARPED_PLAINS, ThermorariumBiomeCreators.createNetherForestTypeBiome(false, false));
        register(ThermorariumBiomeKeys.CRIMSON_MARSHLAND, ThermorariumBiomeCreators.createNetherForestTypeBiome(true, true));
        register(ThermorariumBiomeKeys.WARPED_MARSHLAND, ThermorariumBiomeCreators.createNetherForestTypeBiome(false, true));

        addBiomes();
    }

    private static void addBiomes() {
        add(ThermorariumBiomeKeys.CRIMSON_PLAINS, 0.0F, 0.4F, 0.0F, 0.5F, 0.3F);
        add(ThermorariumBiomeKeys.WARPED_PLAINS, 0.0F, 0.0F, 0.5F, 0.5F, 0.275F);

        add(ThermorariumBiomeKeys.CRIMSON_MARSHLAND, 0.0F, 0.4F, 0.0F, -0.5F, 0.3F);
        add(ThermorariumBiomeKeys.WARPED_MARSHLAND, 0.0F, 0.0F, 0.5F, -0.5F, 0.275F);
    }
}

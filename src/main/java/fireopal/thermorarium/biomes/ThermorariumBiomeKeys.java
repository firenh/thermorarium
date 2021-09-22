package fireopal.thermorarium.biomes;

import fireopal.thermorarium.Thermorarium;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;

public class ThermorariumBiomeKeys {
    private static RegistryKey<Biome> register(String id) {
        return RegistryKey.of(Registry.BIOME_KEY, Thermorarium.id(id));
    }

    public static final RegistryKey<Biome> CRIMSON_PLAINS = register("crimson_plains");
    public static final RegistryKey<Biome> WARPED_PLAINS = register("warped_plains");
    public static final RegistryKey<Biome> CRIMSON_MARSHLAND = register("crimson_marshland");
    public static final RegistryKey<Biome> WARPED_MARSHLAND = register("warped_marshland");
}

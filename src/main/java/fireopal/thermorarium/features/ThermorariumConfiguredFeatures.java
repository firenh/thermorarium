package fireopal.thermorarium.features;

import fireopal.thermorarium.Thermorarium;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;

public class ThermorariumConfiguredFeatures {
    public static ConfiguredFeature<?, ?> SPARSE_CRIMSON_FUNGI;
    public static ConfiguredFeature<?, ?> SPARSE_WARPED_FUNGI;

    private static ConfiguredFeature<FeatureConfig, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return (ConfiguredFeature)Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Thermorarium.id(id), configuredFeature);
    }

    public static void init() {
        SPARSE_CRIMSON_FUNGI = register("sparse_crimson_fungi", 
            Feature.HUGE_FUNGUS.configure(HugeFungusFeatureConfig.CRIMSON_FUNGUS_NOT_PLANTED_CONFIG)
                .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(1))));
        SPARSE_WARPED_FUNGI = register("sparse_warped_fungi", 
            Feature.HUGE_FUNGUS.configure(HugeFungusFeatureConfig.WARPED_FUNGUS_NOT_PLANTED_CONFIG)
                .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(1))));
    }
}

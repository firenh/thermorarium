package fireopal.thermorarium.features;

import fireopal.thermorarium.Thermorarium;
import fireopal.thermorarium.features.config.GroundPeppersFeatureConfig;
import fireopal.thermorarium.features.features.GroundPeppersFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ThermorariumFeatures {
    public static Feature<GroundPeppersFeatureConfig> GROUND_PEPPERS_FEATURE;
    
    private static <C extends FeatureConfig, F extends Feature<C>> F register(String id, F feature) {
        return (F)Registry.register(Registry.FEATURE, Thermorarium.id(id), feature);
    }

    public static void init() {
        GROUND_PEPPERS_FEATURE = register("ground_peppers", new GroundPeppersFeature(GroundPeppersFeatureConfig.CODEC));
    }
}

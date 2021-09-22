package fireopal.thermorarium.features;

import fireopal.thermorarium.Thermorarium;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.CountConfig;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.DeltaFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.HugeFungusFeatureConfig;
import net.minecraft.world.gen.feature.ReplaceBlobsFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

public class ThermorariumConfiguredFeatures {
    public static ConfiguredFeature<?, ?> SPARSE_CRIMSON_FUNGI;
    public static ConfiguredFeature<?, ?> SPARSE_WARPED_FUNGI;

    public static ConfiguredFeature<?, ?> CRIMSON_MARSH_DELTA;
    public static ConfiguredFeature<?, ?> WARPED_MARSH_DELTA;

    public static ConfiguredFeature<?, ?> MAGMA_TO_CRIMSON;
    public static ConfiguredFeature<?, ?> MAGMA_TO_WARPED;
    public static ConfiguredFeature<?, ?> MAGMA_TO_LAVA;

    private static ConfiguredFeature<FeatureConfig, ?> register(String id, ConfiguredFeature<?, ?> configuredFeature) {
        return (ConfiguredFeature)Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, Thermorarium.id(id), configuredFeature);
    }

    private static ConfiguredFeature<?, ?> createMarshlandDeltaFeature(BlockState rimState) {
        return Feature.DELTA_FEATURE.configure(
            new DeltaFeatureConfig(
                Blocks.MAGMA_BLOCK.getDefaultState(), 
                rimState, 
                UniformIntProvider.create(3, 4), 
                UniformIntProvider.create(0, 2)
            )).decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(40)));
    }

    private static ConfiguredFeature<?, ?> createMagmaToBlock(int count, BlockState blockState) {
        return Feature.NETHERRACK_REPLACE_BLOBS.configure(new ReplaceBlobsFeatureConfig(
            Blocks.MAGMA_BLOCK.getDefaultState(), blockState,
            UniformIntProvider.create(0, 1)))
            .range(Decorators.BOTTOM_TO_TOP).spreadHorizontally().repeat(count);
    }

    public static void init() {
        SPARSE_CRIMSON_FUNGI = register("sparse_crimson_fungi", 
            Feature.HUGE_FUNGUS.configure(HugeFungusFeatureConfig.CRIMSON_FUNGUS_NOT_PLANTED_CONFIG)
                .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(1))));
        SPARSE_WARPED_FUNGI = register("sparse_warped_fungi", 
            Feature.HUGE_FUNGUS.configure(HugeFungusFeatureConfig.WARPED_FUNGUS_NOT_PLANTED_CONFIG)
                .decorate(Decorator.COUNT_MULTILAYER.configure(new CountConfig(1))));

        CRIMSON_MARSH_DELTA = register("crimson_marsh_delta", createMarshlandDeltaFeature(Blocks.CRIMSON_NYLIUM.getDefaultState()));
        WARPED_MARSH_DELTA = register("warped_marsh_delta", createMarshlandDeltaFeature(Blocks.WARPED_NYLIUM.getDefaultState()));

        MAGMA_TO_CRIMSON = register("magma_to_crimson", createMagmaToBlock(64, Blocks.CRIMSON_NYLIUM.getDefaultState()));
        MAGMA_TO_WARPED = register("magma_to_warped", createMagmaToBlock(64, Blocks.WARPED_NYLIUM.getDefaultState()));
        MAGMA_TO_LAVA = register("magma_to_lava", createMagmaToBlock(128, Blocks.LAVA.getDefaultState()));
    }
    
    public class Decorators {
        public static final RangeDecoratorConfig BOTTOM_TO_TOP = new RangeDecoratorConfig(UniformHeightProvider.create(YOffset.getBottom(), YOffset.getTop()));
    }
}

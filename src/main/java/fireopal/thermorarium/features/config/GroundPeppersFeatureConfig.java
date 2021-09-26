package fireopal.thermorarium.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public record GroundPeppersFeatureConfig(IntProvider size, IntProvider chance, BlockState target, BlockState blockState, IntProvider requiresContainment) implements FeatureConfig {
   public static final Codec<GroundPeppersFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
      IntProvider.VALUE_CODEC.fieldOf("size").forGetter(GroundPeppersFeatureConfig::size),
      IntProvider.VALUE_CODEC.fieldOf("chance").forGetter(GroundPeppersFeatureConfig::chance),
      BlockState.CODEC.fieldOf("target").forGetter(GroundPeppersFeatureConfig::target),
      BlockState.CODEC.fieldOf("blockState").forGetter(GroundPeppersFeatureConfig::blockState),
      IntProvider.VALUE_CODEC.fieldOf("requiresContainment").forGetter(GroundPeppersFeatureConfig::requiresContainment)
   ).apply(instance, instance.stable(GroundPeppersFeatureConfig::new)));
}
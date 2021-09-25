/*package fireopal.thermorarium.features.config;

import com.mojang.datafixers.util.Function3;
import com.mojang.datafixers.util.Function4;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.gen.feature.FeatureConfig;

public class GroundPeppersFeatureConfig implements FeatureConfig {
   public static final Codec<Object> CODEC = RecordCodecBuilder.create((instance) -> {
      return instance.group(BlockState.CODEC.fieldOf("target").forGetter((groundPeppersFeatureConfig) -> {
         return groundPeppersFeatureConfig.target;
      }), BlockState.CODEC.fieldOf("blockstate").forGetter((groundPeppersFeatureConfig) -> {
         return groundPeppersFeatureConfig.blockstate;
      }), IntProvider.createValidatingCodec(0, 16).fieldOf("size").forGetter((groundPeppersFeatureConfig) -> {
         return groundPeppersFeatureConfig.size;
      })).apply(instance, (Function3<BlockState, BlockState, IntProvider, R>)(GroundPeppersFeatureConfig::new));
   });

   private BlockState target;
   private BlockState blockstate;
   private IntProvider size;

   public GroundPeppersFeatureConfig(Object target, Object blockstate, Object size, Object rimSize) {
      this.target = (BlockState)target;
      this.blockstate = (BlockState)blockstate;
      this.size = (IntProvider)size;
   }

   public BlockState getTarget() {
      return this.target;
   }

   public BlockState getBlockstate() {
      return this.blockstate;
   }

   public IntProvider getSize() {
      return this.size;
   }
}

*/

/*package fireopal.thermorarium.features.features;

import java.util.Iterator;
import java.util.Random;

import com.mojang.serialization.Codec;

import fireopal.thermorarium.features.config.GroundPeppersFeatureConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GroundPeppersFeature extends Feature<GroundPeppersFeatureConfig> {

    public GroundPeppersFeature(Codec<GroundPeppersFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<GroundPeppersFeatureConfig> context) {
        boolean bl = false;
        Random random = context.getRandom();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        GroundPeppersFeatureConfig groundPeppersFeatureConfig = (GroundPeppersFeatureConfig)context.getConfig();
        BlockPos blockPos = context.getOrigin();

        boolean bl2 = random.nextFloat() < 0.9F;
        int rangeX = groundPeppersFeatureConfig.getSize().get(random);
        int rangeZ = groundPeppersFeatureConfig.getSize().get(random);

        Iterator<BlockPos> iterator = BlockPos.iterateOutwards(blockPos, rangeX, 0, rangeZ).iterator();

        while(iterator.hasNext()) {
            BlockPos iteratorPos = iterator.next();

        }
    }
}

*/
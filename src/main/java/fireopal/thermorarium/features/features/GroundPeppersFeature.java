package fireopal.thermorarium.features.features;

import java.util.Iterator;
import java.util.Random;

import com.mojang.serialization.Codec;

import fireopal.thermorarium.features.config.GroundPeppersFeatureConfig;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class GroundPeppersFeature extends Feature<GroundPeppersFeatureConfig> {
    public GroundPeppersFeature(Codec<GroundPeppersFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<GroundPeppersFeatureConfig> context) {
        boolean bl = false;

        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        BlockPos blockPos = context.getOrigin();
        GroundPeppersFeatureConfig config = context.getConfig();

        int size = config.size().get(random);
        int chance = config.chance().get(random);
        BlockState target = config.target();
        BlockPos blockPos2;
        BlockState originalBlockState;
        boolean contained = false;

        if (size > 24) {
            return false;
        }

        Iterator<BlockPos> iterator = BlockPos.iterate(blockPos.add(-size - 1, -size - 1, -size - 1), blockPos.add(size + 1, size + 1, size + 1)).iterator();

        while (iterator.hasNext()) {
            blockPos2 = (BlockPos)iterator.next();
            originalBlockState = world.getBlockState(blockPos2);

            if ((originalBlockState == target) && (world.getBlockState(blockPos2.up()).isAir())) {
                if (config.requiresContainment().get(random) > 0) {
                    contained = contained(world, blockPos);
                } else {
                    contained = true;
                }

                //TODO make it generate in a circle
                if ((random.nextInt(100) <= chance) && (contained)) {
                    bl = true;
                    this.setBlockState(world, blockPos2, config.blockState());
                }
            }
        }
        
        return bl;
    }

    static boolean contained(StructureWorldAccess world, BlockPos blockPos) {
        boolean bl1 = world.getBlockState(blockPos.down()).isAir();
        boolean bl2 = world.getBlockState(blockPos.north()).isAir();
        boolean bl3 = world.getBlockState(blockPos.south()).isAir();
        boolean bl4 = world.getBlockState(blockPos.east()).isAir();
        boolean bl5 = world.getBlockState(blockPos.west()).isAir();

        return (((bl1 && bl2) && (bl3 && bl4) ) && bl5);
    }
}
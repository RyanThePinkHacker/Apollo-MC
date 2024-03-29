package com.thepinkhacker.apollo.fluid;

import com.thepinkhacker.apollo.block.ApolloBlocks;
import com.thepinkhacker.apollo.item.ApolloItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.World;

public abstract class FuelFluid extends AbstractFluid {
    @Override
    public Fluid getStill() {
        return ApolloFluids.STILL_FUEL;
    }

    @Override
    public Fluid getFlowing() {
        return ApolloFluids.FLOWING_FUEL;
    }

    @Override
    public Item getBucketItem() {
        return ApolloItems.FUEL_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        return ApolloBlocks.FUEL.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    public float getBlastResistance() {
        return 100.0f;
    }

    @Override
    public boolean isInfinite(World world) {
        return false;
    }

    public static class Flowing extends FuelFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends FuelFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}

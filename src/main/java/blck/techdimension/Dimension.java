package blck.techdimension;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;

import static blck.techdimension.TechDimensionMod.MODID;

public class Dimension {

    public static final ResourceLocation TECH_DIMENSION_DIM_ID = new ResourceLocation(MODID, "tech_dimension");
    public static final ResourceKey<Level> TECH_DIMENSION = ResourceKey.create(Registries.DIMENSION, TECH_DIMENSION_DIM_ID);
    public static final ResourceKey<DimensionType> TECH_DIMENSION_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, TECH_DIMENSION_DIM_ID);
}

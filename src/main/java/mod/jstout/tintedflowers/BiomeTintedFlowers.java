package mod.jstout.tintedflowers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockColorRegistry;
import net.minecraft.client.color.block.BlockTintSource;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Set;

public class BiomeTintedFlowers implements ClientModInitializer {
  // Custom BlockTintSource that mimics the old ColorProviderRegistry lambda
  private static final BlockTintSource BIOME_GRASS_TINT = new BlockTintSource() {
    @Override
    public int color(BlockState state) {
      // Default color if world/pos is missing
      return GrassColor.getDefaultColor();
    }

    @Override
    public int colorInWorld(BlockState state, BlockAndTintGetter world, BlockPos pos) {
      if (world == null || pos == null) return GrassColor.getDefaultColor();
      return BiomeColors.getAverageGrassColor(world, pos);
    }

    @Override
    public int colorAsTerrainParticle(BlockState state, BlockAndTintGetter world, BlockPos pos) {
      return colorInWorld(state, world, pos);
    }

    @Override
    public Set<Property<?>> relevantProperties() {
      return Set.of();
    }
  };
  
  @Override
  public void onInitializeClient() {
    BlockColorRegistry.register(
      List.of(BIOME_GRASS_TINT),
      Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.BLUE_ORCHID, Blocks.CORNFLOWER, Blocks.DANDELION, Blocks.LILY_OF_THE_VALLEY, Blocks.OXEYE_DAISY, Blocks.POPPY, Blocks.TORCHFLOWER_CROP, Blocks.TORCHFLOWER, Blocks.ORANGE_TULIP, Blocks.PINK_TULIP, Blocks.RED_TULIP, Blocks.WHITE_TULIP, Blocks.WITHER_ROSE,
      Blocks.LILAC, Blocks.PEONY, Blocks.PITCHER_CROP, Blocks.PITCHER_PLANT, Blocks.ROSE_BUSH, Blocks.SUNFLOWER,
      Blocks.BEETROOTS, Blocks.CARROTS, Blocks.POTATOES, Blocks.WHEAT,
      Blocks.CAVE_VINES, Blocks.CAVE_VINES_PLANT, Blocks.FIREFLY_BUSH, Blocks.SWEET_BERRY_BUSH
    );
  }
}

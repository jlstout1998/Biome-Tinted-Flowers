package mod.jstout.tintedflowers;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Blocks;

public class BiomeTintedFlowers implements ClientModInitializer {
  
  @Override
  public void onInitializeClient() {
    ColorProviderRegistry.BLOCK.register(
      ((state, world, pos, tintIndex) -> world != null && pos != null ? BiomeColors.getAverageGrassColor(world, pos) : GrassColor.getDefaultColor()),
      Blocks.ALLIUM, Blocks.AZURE_BLUET, Blocks.BLUE_ORCHID, Blocks.CORNFLOWER, Blocks.DANDELION, Blocks.LILY_OF_THE_VALLEY, Blocks.OXEYE_DAISY, Blocks.POPPY, Blocks.TORCHFLOWER_CROP, Blocks.TORCHFLOWER, Blocks.ORANGE_TULIP, Blocks.PINK_TULIP, Blocks.RED_TULIP, Blocks.WHITE_TULIP, Blocks.WITHER_ROSE,
      Blocks.LILAC, Blocks.PEONY, Blocks.PITCHER_CROP, Blocks.PITCHER_PLANT, Blocks.ROSE_BUSH, Blocks.SUNFLOWER,
      Blocks.BEETROOTS, Blocks.CARROTS, Blocks.POTATOES, Blocks.WHEAT
    );
  }
}

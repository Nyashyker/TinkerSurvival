package tinkersurvival.data;

import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.tools.data.sprite.TinkerMaterialSpriteProvider;

import tinkersurvival.data.client.ModItemModelProvider;
import tinkersurvival.data.overrides.BlockTagsOverrideProvider;
import tinkersurvival.data.recipes.ModRecipesProvider;
import tinkersurvival.data.tcon.MaterialPartTextureGenerator;
import tinkersurvival.data.tcon.sprite.SawPartSpriteProvider;
import tinkersurvival.data.tcon.StationSlotLayoutProvider;
import tinkersurvival.data.tcon.ToolDefinitionDataProvider;
import tinkersurvival.data.tcon.ToolsRecipeProvider;
import tinkersurvival.TinkerSurvival;

@Mod.EventBusSubscriber(modid = TinkerSurvival.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        ModBlockTagsProvider blockTags = new ModBlockTagsProvider(gen, existingFileHelper);
        SawPartSpriteProvider sawPartSprites = new SawPartSpriteProvider();
        String modpackOverrides = System.getenv("MOD_OVERRIDES");
        TinkerMaterialSpriteProvider materialSprites = new TinkerMaterialSpriteProvider();

        gen.addProvider(true, new ModItemModelProvider(gen, existingFileHelper));
        gen.addProvider(true, blockTags);
        gen.addProvider(true, new ModItemTagsProvider(gen, blockTags, existingFileHelper));
        gen.addProvider(true, new ModRecipesProvider(gen));
        gen.addProvider(true, new ToolsRecipeProvider(gen));
        gen.addProvider(true, new StationSlotLayoutProvider(gen));
        gen.addProvider(true, new GeneratorPartTextureJsonGenerator(gen, TinkerSurvival.MODID, sawPartSprites));
        gen.addProvider(true, new ToolDefinitionDataProvider(gen));

        if (event.includeClient()) {
            gen.addProvider(true, new MaterialPartTextureGenerator(gen, existingFileHelper, sawPartSprites, materialSprites));
        }

        if (modpackOverrides != null && modpackOverrides.contains("all")) {
            gen.addProvider(true, new BlockTagsOverrideProvider(gen, event.getExistingFileHelper()));
        }
    }

}

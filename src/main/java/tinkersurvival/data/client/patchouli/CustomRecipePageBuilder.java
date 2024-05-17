package tinkersurvival.data.client.patchouli;

import homeostatic.Homeostatic;

import net.minecraft.resources.ResourceLocation;

import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.page.RecipePageBuilder;

public class CustomRecipePageBuilder extends RecipePageBuilder<CustomRecipePageBuilder> {

    protected CustomRecipePageBuilder(ResourceLocation recipe, EntryBuilder parent) {
        super(Homeostatic.MODID + ":custom_crafting", recipe, parent);
    }

}

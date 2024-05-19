package tinkersurvival.data.client.patchouli;

import net.minecraft.resources.ResourceLocation;

import xyz.brassgoggledcoders.patchouliprovider.EntryBuilder;
import xyz.brassgoggledcoders.patchouliprovider.page.RecipePageBuilder;

public class CustomRecipePageBuilder extends RecipePageBuilder<CustomRecipePageBuilder> {

    protected CustomRecipePageBuilder(String pageCrafting, ResourceLocation recipe, EntryBuilder parent) {
        super(pageCrafting, recipe, parent);
    }

}

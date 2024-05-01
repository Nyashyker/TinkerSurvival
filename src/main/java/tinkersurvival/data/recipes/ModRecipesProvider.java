package tinkersurvival.data.recipes;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

public class ModRecipesProvider extends RecipeProvider {

    public ModRecipesProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public @NotNull String getName() {
        return "TinkerSurvival - Recipies";
    }

    @Override
    protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
    }

}

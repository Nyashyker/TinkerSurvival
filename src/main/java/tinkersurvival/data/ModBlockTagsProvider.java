package tinkersurvival.data;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.DataGenerator;

import net.minecraftforge.common.data.ExistingFileHelper;

import tinkersurvival.TinkerSurvival;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, TinkerSurvival.MODID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "TinkerSurvival - Block Tags";
    }

    @Override 
    protected void addTags() {
    }

}

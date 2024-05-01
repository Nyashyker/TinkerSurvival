package tinkersurvival.data;

import java.util.function.Consumer;

import org.jetbrains.annotations.NotNull;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;

import net.minecraftforge.common.data.ExistingFileHelper;

import slimeknights.tconstruct.common.registration.CastItemObject;

import static slimeknights.tconstruct.common.TinkerTags.Items.DURABILITY;
import static slimeknights.tconstruct.common.TinkerTags.Items.GOLD_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.HARVEST_PRIMARY;
import static slimeknights.tconstruct.common.TinkerTags.Items.MULTIPART_TOOL;
import static slimeknights.tconstruct.common.TinkerTags.Items.MELEE_WEAPON;
import static slimeknights.tconstruct.common.TinkerTags.Items.RED_SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.SAND_CASTS;
import static slimeknights.tconstruct.common.TinkerTags.Items.TOOL_PARTS;

import tinkersurvival.common.TagManager;
import tinkersurvival.items.TConItems;
import tinkersurvival.TinkerSurvival;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, TinkerSurvival.MODID, existingFileHelper);
    }

    @Override
    public @NotNull String getName() {
        return "TinkerSurvival - Item Tags";
    }

    @Override
    protected void addTags() {
        Consumer<CastItemObject> addCast = cast -> {
            this.tag(GOLD_CASTS).add(cast.get());
            this.tag(TagManager.Items.SAW_BLADE_CAST).add(cast.get());
            this.tag(SAND_CASTS).add(cast.getSand());
            this.tag(TagManager.Items.SAW_BLADE_CAST_SINGLE).add(cast.getSand());
            this.tag(RED_SAND_CASTS).add(cast.getRedSand());
            this.tag(TagManager.Items.SAW_BLADE_CAST_SINGLE).add(cast.getRedSand());
        };

        this.tag(MULTIPART_TOOL).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(DURABILITY).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(MELEE_WEAPON).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(HARVEST_PRIMARY).add(
            TConItems.SAW.get(),
            TConItems.KNIFE.get()
        );
        this.tag(TOOL_PARTS).add(TConItems.SAW_BLADE.get());

        addCast.accept(TConItems.SAW_BLADE_CAST);
    }

}

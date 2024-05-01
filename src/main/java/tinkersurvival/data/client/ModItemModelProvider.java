package tinkersurvival.data.client;

import java.util.Objects;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;

import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import slimeknights.tconstruct.common.registration.CastItemObject;

import tinkersurvival.items.TConItems;
import tinkersurvival.TinkerSurvival;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, TinkerSurvival.MODID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "TinkerSurvival - Item Models";
    }

    @Override
    protected void registerModels() {
        addCastModels(TConItems.SAW_BLADE_CAST);
    }

    private void addCastModels(CastItemObject cast) {
        ResourceLocation idGold = cast.getId();
        String path = idGold.getPath().replace("_cast", "");
        ResourceLocation textureLocationGold = new ResourceLocation(idGold.getNamespace(), "item/cast/" + path);
        ResourceLocation idSand = Registry.ITEM.getKey(cast.getSand().asItem());
        ResourceLocation textureLocationSand = new ResourceLocation(Objects.requireNonNull(idSand).getNamespace(), "item/sand_cast/" + path);
        ResourceLocation idSandRed = Registry.ITEM.getKey(cast.getRedSand().asItem());
        ResourceLocation textureLocationSandRed = new ResourceLocation(Objects.requireNonNull(idSandRed).getNamespace(), "item/red_sand_cast/" + path);
        ResourceLocation loc = mcLoc("item/generated");

        singleTexture(idGold.getPath(), loc, "layer0", textureLocationGold);
        singleTexture(idSand.getPath(), loc, "layer0", textureLocationSand);
        singleTexture(idSandRed.getPath(), loc, "layer0", textureLocationSandRed);        
    }

}

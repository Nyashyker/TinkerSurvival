package tinkersurvival.common;

import net.minecraftforge.eventbus.api.IEventBus;

import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;

import tinkersurvival.TinkerSurvival;

public abstract class TinkerSurvivalModule {

    protected static final ItemDeferredRegisterExtension ITEM_TCON_REGISTRY = new ItemDeferredRegisterExtension(TinkerSurvival.MODID);

    protected TinkerSurvivalModule() {}

    public static void initRegistries(IEventBus bus) {
        ITEM_TCON_REGISTRY.register(bus);
    }

}

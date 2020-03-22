package net.mineclave.fabric.registry;

import net.mineclave.fabric.EnclaveMain;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class EnclaveItems {
    public static Item STEEL_INGOT = register(new Item(new Item.Settings().group(EnclaveItemGroups.ENCLAVEITEMS)), "steel_ingot");

    public static void init() {
    }

    public static <I extends Item> I register(I item, String path) {
        return Registry.register(Registry.ITEM, EnclaveMain.id(path), item);
    }
}

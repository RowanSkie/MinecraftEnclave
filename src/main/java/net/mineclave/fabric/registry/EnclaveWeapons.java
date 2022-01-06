package net.mineclave.fabric.registry;

import net.mineclave.fabric.EnclaveMain;
import net.mineclave.fabric.items.WeaponItem;
import net.minecraft.item.SwordItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.registry.Registry;

public class EnclaveWeapons {
    private static final ClaveMaterial material = new ClaveMaterial(1, 0, 0.5F, 2.5F, 750, () -> Ingredient.ofItems(EnclaveItems.STEEL_INGOT));

    public static WeaponItem BATON = register(new WeaponItem(material, 2, 0.5F, EnclaveItemGroups.ITEMGROUP_WEAP),
            "wep_baton");

    public static void init() {
    }

    public static <I extends SwordItem> I register(I item, String path) {
        return Registry.register(Registry.ITEM, EnclaveMain.id(path), item);
    }
}


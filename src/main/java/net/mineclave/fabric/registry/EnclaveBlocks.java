package net.mineclave.fabric.registry;

import net.mineclave.fabric.EnclaveMain;
import net.mineclave.fabric.block.SteelBlockItem;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class EnclaveBlocks {
    public static final Block.Settings STEEL_OPAQUE_SETTINGS = Block.Settings.of(Material.METAL);

    public static final SteelBlockItem STEEL_BLOCK = register(new SteelBlockItem(STEEL_OPAQUE_SETTINGS), "steel_block");

    public static void init() {
    }

    public static <S extends Block> S register(S block, String path) {
        return register(block, path, EnclaveItemGroups.ITEMGROUP_BLOCKS);
    }

    public static <S extends Block> S register(S block, String path, Item.Settings settings){
        S b = Registry.register(Registry.BLOCK, EnclaveMain.id(path), block);
        Registry.register(Registry.ITEM, EnclaveMain.id(path), new BlockItem(block, settings));
        return b;
    }
}

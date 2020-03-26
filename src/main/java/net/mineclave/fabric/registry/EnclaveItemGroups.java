package net.mineclave.fabric.registry;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class EnclaveItemGroups{
    public static final ItemGroup ENCLAVEMATERIALS = FabricItemGroupBuilder.build(
            new Identifier("mineclave", "materials"),
            () -> new ItemStack(EnclaveItems.STEEL_INGOT));

    public static final ItemGroup ENCLAVEBLOCKS = FabricItemGroupBuilder.build(
            new Identifier("mineclave", "blocks"),
            () -> new ItemStack(EnclaveBlocks.STEEL_BLOCK));

    public static final ItemGroup ENCLAVEWEAP = FabricItemGroupBuilder.build(
            new Identifier("mineclave", "weapons"),
            () -> new ItemStack(EnclaveWeapons.BATON));

    public static final Item.Settings ITEMGROUP_MATERIALS = new Item.Settings().group(ENCLAVEMATERIALS);
    public static final Item.Settings ITEMGROUP_BLOCKS = new Item.Settings().group(ENCLAVEBLOCKS);
    public static final Item.Settings ITEMGROUP_WEAP = new Item.Settings().maxCount(1).group(ENCLAVEWEAP);
}

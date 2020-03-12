package net.RowanSkie.main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnclaveMain implements ModInitializer {
	public static final ItemGroup ENCLAVEITEMS = FabricItemGroupBuilder.build(
	new Identifier("mainclave", "general"),
	() -> new ItemStack(Items.APPLE));

	public static final DebugItem debug = new DebugItem(new Item.Settings().group(ItemGroup.ENCLAVEITEMS));

	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("mineclave", "debugitem"), debug);
	}
}

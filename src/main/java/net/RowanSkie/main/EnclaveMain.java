package net.RowanSkie.main;

import net.RowanSkie.main.items.BatonWeapon;
import net.RowanSkie.main.items.DebugItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnclaveMain implements ModInitializer {

	//ItemGroup
	public static final ItemGroup ENCLAVEITEMS = FabricItemGroupBuilder.build(
	new Identifier("mineclave", "general"),
	() -> new ItemStack(EnclaveMain.debug));
	public static final ItemGroup ENCLAVEWEAP = FabricItemGroupBuilder.create(
	new Identifier("mineclave", "weapons"))
	.icon(() -> new ItemStack(EnclaveMain.batonweap))
	.appendItems(stacks ->
	{
		stacks.add(new ItemStack(EnclaveMain.batonweap));
	})
	.build();

	// Items
	public static final DebugItem debug = new DebugItem(new Item.Settings().group(EnclaveMain.ENCLAVEITEMS).maxCount(1));
	public static final BatonWeapon batonweap = new BatonWeapon(new Item.Settings().group(EnclaveMain.ENCLAVEWEAP));

	// Initialization
	@Override
	public void onInitialize()
	{
		Registry.register(Registry.ITEM, new Identifier("mineclave", "debugitem"), debug);
		Registry.register(Registry.ITEM, new Identifier("mineclave", "wep_baton"), batonweap);
	}
}

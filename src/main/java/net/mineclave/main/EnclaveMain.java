package net.mineclave.main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mineclave.main.items.DebugItem;
import net.mineclave.main.items.SteelItem;
import net.mineclave.main.items.WeaponItem;

public class EnclaveMain implements ModInitializer {

	//ItemGroup
	public static final ItemGroup ENCLAVEITEMS = FabricItemGroupBuilder.build (
		new Identifier("mineclave", "general"),
		() -> new ItemStack(EnclaveMain.debug)
	);
	
	public static final ItemGroup ENCLAVEMATERIALS = FabricItemGroupBuilder.build (
		new Identifier("mineclave", "general"),
		() -> new ItemStack(EnclaveMain.steel)
	);

	public static final ItemGroup ENCLAVEWEAP = FabricItemGroupBuilder.create (
		new Identifier("mineclave", "weapons")
	)
	.icon(() -> new ItemStack(EnclaveMain.batonweap))
	.appendItems(stacks -> {
		stacks.add(new ItemStack(EnclaveMain.batonweap));
	})
	.build();

	// Items
	public static final DebugItem debug = new DebugItem(new Item.Settings().group(EnclaveMain.ENCLAVEITEMS));
	public static final WeaponItem batonweap = new WeaponItem(2,new Item.Settings().group(EnclaveMain.ENCLAVEWEAP).maxCount(1));
	public static final SteelItem steel = new SteelItem(new Item.Settings().group(EnclaveMain.ENCLAVEMATERIALS));

	// Initialization
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("mineclave", "debugitem"), debug);
		Registry.register(Registry.ITEM, new Identifier("mineclave", "wep_baton"), batonweap);
		Registry.register(Registry.ITEM, new Identifier("mineclave","steelingot"), steel);
		System.out.print("Item initialization complete.");
	}
}

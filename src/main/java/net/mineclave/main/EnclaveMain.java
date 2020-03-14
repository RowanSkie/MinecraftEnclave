package net.mineclave.main;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.mineclave.main.items.ClaveMaterial;
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
		new Identifier("mineclave", "materials"),
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

	// ToolMaterial
	private static final ClaveMaterial material = new ClaveMaterial(1, 0, 0.5F, 2F, 750, () -> {return Ingredient.ofItems(EnclaveMain.steel);});
	
	// Items
	public static final DebugItem debug = new DebugItem(new Item.Settings().group(EnclaveMain.ENCLAVEITEMS));
	public static final WeaponItem batonweap = new WeaponItem(material, 2, 1, new Item.Settings().group(EnclaveMain.ENCLAVEWEAP).maxCount(1).maxDamage(450));
	public static final SteelItem steel = new SteelItem(new Item.Settings().group(EnclaveMain.ENCLAVEMATERIALS));

	// Initialization
	@Override
	public void onInitialize() {
		Registry.register(Registry.ITEM, new Identifier("mineclave", "debugitem"), debug);

		Registry.register(Registry.ITEM, new Identifier("mineclave", "wep_baton"), batonweap);

		Registry.register(Registry.ITEM, new Identifier("mineclave","steel_ingot"), steel);
		System.out.print("Item initialization complete.");
	}
}

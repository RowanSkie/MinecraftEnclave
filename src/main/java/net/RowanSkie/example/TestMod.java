package net.RowanSkie.example;

import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TestMod implements ModInitializer {
	public static final FabricItem ITEM = new FabricItem(new Item.Settings().group(ItemGroup.MISC));
	
	@Override
	public void onInitialize()
	{
        Registry.register(Registry.ITEM, new Identifier("modmain", "fabric_item"), ITEM);
	}
}

package net.mineclave.main.items;

import java.util.List;
import com.google.common.collect.Multimap;

import net.mineclave.main.EnclaveMain;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class WeaponItem extends ToolItem {
    private static float attackDamage;
    private static ClaveMaterial material = new ClaveMaterial(1, 0, 5F, attackDamage, 750, () -> {return Ingredient.ofItems(EnclaveMain.steel);});

    public WeaponItem(final int attackDamage, final Settings settings) {
        super(material, settings);
        WeaponItem.attackDamage = (float) attackDamage + material.getAttackDamage();
    }

    public float getAttackDamage() {
        return WeaponItem.attackDamage;
     }
  
    @Override
    public TypedActionResult<ItemStack> use(final World world, final PlayerEntity playerEntity, final Hand hand) {
        return new TypedActionResult<>(ActionResult.SUCCESS, playerEntity.getStackInHand(hand));
    }

    @Override
    public void appendTooltip(final ItemStack itemStack, final World world, final List<Text> tooltip,
            final TooltipContext tooltipContext) {
        tooltip.add(new TranslatableText("item.mineclave.wep_baton.tooltip"));
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getModifiers(final EquipmentSlot slot) {
        final Multimap<String, EntityAttributeModifier> multimap = super.getModifiers(slot);
        if (slot == EquipmentSlot.MAINHAND) {
           multimap.put(EntityAttributes.ATTACK_DAMAGE.getId(), new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_UUID, "Weapon modifier", (double) WeaponItem.attackDamage, EntityAttributeModifier.Operation.ADDITION));
        }
  
        return multimap;
    }
}
package net.mineclave.main.items;

import java.util.List;

import com.google.common.collect.Multimap;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class WeaponItem extends SwordItem {
    private final float attackDamage;
    private final float attackSpeed;

    public WeaponItem(final ClaveMaterial material, final int attackDamage, final float attackSpeed,
            final Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
        this.attackSpeed = attackSpeed;
        this.attackDamage = (float) attackDamage + material.getAttackDamage();
    }

    public float getAttackDamage() {
        return this.attackDamage;
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
           multimap.put(EntityAttributes.ATTACK_DAMAGE.getId(), new EntityAttributeModifier(ATTACK_DAMAGE_MODIFIER_UUID, "Weapon modifier", (double)this.attackDamage, EntityAttributeModifier.Operation.ADDITION));
           multimap.put(EntityAttributes.ATTACK_SPEED.getId(), new EntityAttributeModifier(ATTACK_SPEED_MODIFIER_UUID, "Weapon modifier", (double)this.attackSpeed, EntityAttributeModifier.Operation.ADDITION));
        }
  
        return multimap;
    }
}
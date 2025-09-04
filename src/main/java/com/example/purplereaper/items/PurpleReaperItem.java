package com.example.purplereaper.items;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PurpleReaperItem extends SwordItem {
    
    private final float customAttackDamage;
    private final float customAttackSpeed;

    public PurpleReaperItem(float attackDamage, float attackSpeed, Settings settings) {
        // NETHERITE base attack damage = 5
        // SwordItem base attack speed = -2.4f

        super(
            ToolMaterials.NETHERITE,
            (int)(attackDamage - 5),              // Adjust for material base damage
            attackSpeed - 4.0f,                   // Subtract 4.0 so tooltip shows correct value
            settings
        );

        this.customAttackDamage = attackDamage;
        this.customAttackSpeed = attackSpeed;


    }

    @Override
    public float getAttackDamage() {
        return this.customAttackDamage; // Return the exact config value
    }

    public float getCustomAttackSpeed() {
        return this.customAttackSpeed; // Return the exact config value
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.literal("§5§lPurple Reaper").formatted(Formatting.LIGHT_PURPLE);
    }


}

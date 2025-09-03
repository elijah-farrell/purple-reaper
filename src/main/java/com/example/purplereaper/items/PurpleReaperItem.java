package com.example.purplereaper.items;

import com.example.purplereaper.config.ConfigManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PurpleReaperItem extends SwordItem {

    public PurpleReaperItem(Settings settings) {
        super(ToolMaterials.NETHERITE, 7, -2.4f, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        ConfigManager.PurpleSwordConfig config = ConfigManager.getConfig().purple_reaper;
        
        // Apply effects to target based on config
        if (config.weakness_effect) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, config.weakness_duration, config.weakness_amplifier));
        }
        
        if (config.slowness_effect) {
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, config.slowness_duration, config.slowness_amplifier));
        }
        
        // Apply strength to the attacker based on config
        if (config.strength_effect) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, config.strength_duration, config.strength_amplifier));
        }

        return super.postHit(stack, target, attacker);
    }

    @Override
    public Text getName(ItemStack stack) {
        return Text.literal("§5§lPurple Reaper").formatted(Formatting.LIGHT_PURPLE);
    }
}

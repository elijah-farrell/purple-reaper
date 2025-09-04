package com.example.purplereaper;

import com.example.purplereaper.config.ConfigManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.purplereaper.items.FlamingPurpleReaperItem;
import com.example.purplereaper.items.PurpleReaperItem;

public class PurpleReaperMod implements ModInitializer {
    public static final String MOD_ID = "purple-reaper";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Register the custom sword items
    public static Item FLAMING_PURPLE_REAPER;
    public static Item PURPLE_REAPER;

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Purple Reaper Mod");

        // Initialize config
        ConfigManager.init();

        // Create items with config values
        ConfigManager.FlamingSwordConfig flamingConfig = ConfigManager.getConfig().flaming_purple_reaper;
        ConfigManager.PurpleSwordConfig purpleConfig = ConfigManager.getConfig().purple_reaper;

        // Only create items if they are enabled
        if (flamingConfig.enabled) {
            FLAMING_PURPLE_REAPER = new FlamingPurpleReaperItem(
                flamingConfig.attack_damage,
                flamingConfig.attack_speed,
                new FabricItemSettings().maxDamage(flamingConfig.durability)
            );
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flaming_purple_reaper"), FLAMING_PURPLE_REAPER);
        }

        if (purpleConfig.enabled) {
            PURPLE_REAPER = new PurpleReaperItem(
                purpleConfig.attack_damage,
                purpleConfig.attack_speed,
                new FabricItemSettings().maxDamage(purpleConfig.durability)
            );
            Registry.register(Registries.ITEM, new Identifier(MOD_ID, "purple_reaper"), PURPLE_REAPER);
        }

        // Add to combat creative tab only if items exist
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            if (FLAMING_PURPLE_REAPER != null) {
                content.add(FLAMING_PURPLE_REAPER);
            }
            if (PURPLE_REAPER != null) {
                content.add(PURPLE_REAPER);
            }
        });

        LOGGER.info("Purple Reaper Mod initialized successfully!");
    }
}

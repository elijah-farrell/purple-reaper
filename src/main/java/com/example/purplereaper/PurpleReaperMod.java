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
    public static final Item FLAMING_PURPLE_REAPER = new FlamingPurpleReaperItem(new FabricItemSettings().maxDamage(2500));
    public static final Item PURPLE_REAPER = new PurpleReaperItem(new FabricItemSettings().maxDamage(2000));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Purple Reaper Mod");

        // Initialize config
        ConfigManager.init();

        // Register the custom swords
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "flaming_purple_reaper"), FLAMING_PURPLE_REAPER);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, "purple_reaper"), PURPLE_REAPER);

        // Add to combat creative tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.add(FLAMING_PURPLE_REAPER);
            content.add(PURPLE_REAPER);
        });

        LOGGER.info("Purple Reaper Mod initialized successfully!");
    }
}

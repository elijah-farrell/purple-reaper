package com.example.purplereaper.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConfigManager {
    private static final Logger LOGGER = LoggerFactory.getLogger("purple-reaper");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static ConfigData config;
    
    public static class ConfigData {
        public FlamingSwordConfig flaming_purple_reaper = new FlamingSwordConfig();
        public PurpleSwordConfig purple_reaper = new PurpleSwordConfig();
    }
    
    public static class FlamingSwordConfig {
        public boolean enabled = true;
        public int attack_damage = 8;
        public float attack_speed = -2.4f;
        public int durability = 2500;
        public boolean fire_effect = true;
        public int fire_duration = 5;
        public boolean weakness_effect = true;
        public int weakness_duration = 100;
        public int weakness_amplifier = 1;
        public boolean slowness_effect = true;
        public int slowness_duration = 60;
        public int slowness_amplifier = 1;
        public boolean strength_effect = true;
        public int strength_duration = 100;
        public int strength_amplifier = 1;
    }
    
    public static class PurpleSwordConfig {
        public boolean enabled = true;
        public int attack_damage = 7;
        public float attack_speed = -2.4f;
        public int durability = 2000;
        public boolean weakness_effect = true;
        public int weakness_duration = 80;
        public int weakness_amplifier = 1;
        public boolean slowness_effect = true;
        public int slowness_duration = 40;
        public int slowness_amplifier = 1;
        public boolean strength_effect = true;
        public int strength_duration = 80;
        public int strength_amplifier = 1;
    }
    
    public static void init() {
        loadConfig();
    }
    
    public static void loadConfig() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "purple-reaper.json");
        
        if (configFile.exists()) {
            try (FileReader reader = new FileReader(configFile)) {
                config = GSON.fromJson(reader, ConfigData.class);
                LOGGER.info("Loaded config from {}", configFile.getAbsolutePath());
            } catch (IOException e) {
                LOGGER.error("Failed to load config", e);
                config = new ConfigData();
            }
        } else {
            config = new ConfigData();
            saveConfig();
        }
    }
    
    public static void saveConfig() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "purple-reaper.json");
        
        try (FileWriter writer = new FileWriter(configFile)) {
            GSON.toJson(config, writer);
            LOGGER.info("Saved config to {}", configFile.getAbsolutePath());
        } catch (IOException e) {
            LOGGER.error("Failed to save config", e);
        }
    }
    
    public static ConfigData getConfig() {
        return config;
    }
}


# Purple Reaper - Fabric Mod

A Minecraft Fabric mod for version 1.20.1 that adds two powerful custom swords: the Flaming Purple Reaper and the Purple Reaper.

[![Minecraft](https://img.shields.io/badge/Minecraft-1.20.1-green.svg)](https://minecraft.net)
[![Fabric](https://img.shields.io/badge/Fabric-Loader-blue.svg)](https://fabricmc.net)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## 📖 Overview

This mod converts custom resource pack swords into fully functional Fabric mod items with special abilities, configurable stats, and proper integration with Minecraft's systems.

## Features

### 🗡️ **Flaming Purple Reaper Sword**
- **Custom 3D Model**: Uses the original resource pack's detailed sword model
- **Special Effects**:
  - Sets enemies on fire when hit
  - Applies weakness and slowness to targets
  - Grants strength to the wielder
- **High Durability**: 2500 durability points (configurable)
- **Attack Damage**: 8 (configurable)
- **Attack Speed**: -2.4 (configurable)

### ⚔️ **Purple Reaper Sword**
- **Custom 3D Model**: Non-flaming version with detailed geometry
- **Special Effects**:
  - Applies weakness and slowness to targets
  - Grants strength to the wielder
- **Durability**: 2000 durability points (configurable)
- **Attack Damage**: 7 (configurable)
- **Attack Speed**: -2.4 (configurable)

## Requirements

- Minecraft 1.20.1
- Fabric Loader 0.14.21+
- Fabric API

## 🚀 Installation

### Prerequisites
- Minecraft 1.20.1
- [Fabric Loader](https://fabricmc.net/use/) 0.14.21+
- [Fabric API](https://modrinth.com/mod/fabric-api)

### Quick Install
1. Download the latest release JAR file from [Releases](../../releases)
2. Place it in your `mods` folder
3. Start Minecraft

### Manual Build
```bash
git clone https://github.com/elijah-farrell/purple-reaper.git
cd purple-reaper
./gradlew build
```
The built JAR will be in `build/libs/`

## Crafting Recipes

Both swords can be crafted using:
- 2 Netherite Ingots
- 1 Stick

```
 N
 N
 S
```

Where N = Netherite Ingot, S = Stick

## Configuration System

The mod includes a comprehensive configuration system that allows you to customize both swords. The config file is located at:
```
config/purple-reaper.json
```

**Note**: Attack damage and speed changes require a game restart to take effect.

### Configuration Options

#### Flaming Purple Reaper
```json
{
  "flaming_purple_reaper": {
    "enabled": true,
    "attack_damage": 8,
    "attack_speed": -2.4,
    "durability": 2500,
    "fire_effect": true,
    "fire_duration": 5,
    "weakness_effect": true,
    "weakness_duration": 100,
    "weakness_amplifier": 1,
    "slowness_effect": true,
    "slowness_duration": 60,
    "slowness_amplifier": 1,
    "strength_effect": true,
    "strength_duration": 100,
    "strength_amplifier": 1
  }
}
```

#### Purple Reaper
```json
{
  "purple_reaper": {
    "enabled": true,
    "attack_damage": 7,
    "attack_speed": -2.4,
    "durability": 2000,
    "weakness_effect": true,
    "weakness_duration": 80,
    "weakness_amplifier": 1,
    "slowness_effect": true,
    "slowness_duration": 40,
    "slowness_amplifier": 1,
    "strength_effect": true,
    "strength_duration": 80,
    "strength_amplifier": 1
  }
}
```

### Config Options Explained

- **enabled**: Enable/disable the sword (true/false)
- **attack_damage**: Base attack damage of the sword (requires restart)
- **attack_speed**: Attack speed modifier (requires restart)
- **durability**: Maximum durability points
- **fire_effect**: Enable fire effect (Flaming Purple Reaper only)
- **fire_duration**: How long enemies burn (in seconds)
- **weakness_effect**: Enable weakness effect on targets
- **weakness_duration**: Duration of weakness effect (in ticks)
- **weakness_amplifier**: Strength of weakness effect (0 = level 1, 1 = level 2, etc.)
- **slowness_effect**: Enable slowness effect on targets
- **slowness_duration**: Duration of slowness effect (in ticks)
- **slowness_amplifier**: Strength of slowness effect
- **strength_effect**: Enable strength effect on wielder
- **strength_duration**: Duration of strength effect (in ticks)
- **strength_amplifier**: Strength of strength effect

## In-Game Commands

To give yourself the swords:
```
/give @s purple-reaper:flaming_purple_reaper
/give @s purple-reaper:purple_reaper
```

## 🛠️ Development

### Requirements
- Java 17+
- Gradle (included in wrapper)

### Building
```bash
./gradlew build
```

### Running in Development
```bash
./gradlew runClient
```

## 📋 Project Structure

```
src/main/
├── java/com/example/purplereaper/
│   ├── PurpleReaperMod.java          # Main mod class
│   ├── items/
│   │   ├── FlamingPurpleReaperItem.java
│   │   └── PurpleReaperItem.java     # Custom sword classes
│   └── config/
│       └── ConfigManager.java        # Configuration system
└── resources/
    ├── assets/purple-reaper/
    │   ├── models/item/               # 3D item models
    │   ├── textures/item/             # Item textures
    │   └── lang/                      # Language files
    ├── data/purple-reaper/
    │   ├── recipes/                   # Crafting recipes
    │   └── tags/                      # Item tags
    └── fabric.mod.json               # Mod metadata
```

## 🔧 Technical Details

This mod was converted from resource packs to a full Fabric mod. The original resource packs contained:
- Custom 3D models for the netherite sword
- Custom textures with purple effects

The mod adds:
- Two custom item classes with enhanced combat abilities
- Proper item registration and integration
- Crafting recipes and item tags
- Language support
- Comprehensive JSON-based configuration system

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🙏 Credits

Original resource pack design and textures belong to the original creator.

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📞 Support

- **Issues**: [GitHub Issues](../../issues)
- **Discussions**: [GitHub Discussions](../../discussions)
- **Releases**: [GitHub Releases](../../releases)

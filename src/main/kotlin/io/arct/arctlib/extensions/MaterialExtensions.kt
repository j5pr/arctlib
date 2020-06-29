@file:Suppress("unused")

package io.arct.arctlib.extensions

import org.bukkit.Material

/**
 * TODO: isEnchantable, isMechanic, isNature, isTradable, isHellCategory
 */

/**
 * Check if a [Material] is an axe.
 *
 * @return Whether the [Material] is an axe.
 */
val Material.isAxe: Boolean
    get() = when (this) {
        Material.WOOD_AXE,
        Material.STONE_AXE,
        Material.IRON_AXE,
        Material.GOLD_AXE,
        Material.DIAMOND_AXE -> true
        else -> false
    }

/**
 * Check if a [Material] is a pickaxe.
 *
 * @return Whether the [Material] is a pickaxe.
 */
val Material.isPickaxe: Boolean
    get() = when (this) {
        Material.WOOD_PICKAXE,
        Material.STONE_PICKAXE,
        Material.IRON_PICKAXE,
        Material.GOLD_PICKAXE,
        Material.DIAMOND_PICKAXE -> true
        else -> false
    }

/**
 * Check if a [Material] is a spade.
 *
 * @return Whether the [Material] is a spade.
 */
val Material.isSpade: Boolean
    get() = when (this) {
        Material.WOOD_SPADE,
        Material.STONE_SPADE,
        Material.IRON_SPADE,
        Material.GOLD_SPADE,
        Material.DIAMOND_SPADE -> true
        else -> false
    }

/**
 * Check if a [Material] is a hoe.
 *
 * @return Whether the [Material] is a hoe.
 */
val Material.isHoe: Boolean
    get() = when (this) {
        Material.WOOD_HOE,
        Material.STONE_HOE,
        Material.IRON_HOE,
        Material.GOLD_HOE,
        Material.DIAMOND_HOE -> true
        else -> false
    }

/**
 * Check if a [Material] is a sword.
 *
 * @return Whether the [Material] is a sword.
 */
val Material.isSword: Boolean
    get() = when (this) {
        Material.WOOD_SWORD,
        Material.STONE_SWORD,
        Material.IRON_SWORD,
        Material.GOLD_SWORD,
        Material.DIAMOND_SWORD -> true
        else -> false
    }

/**
 * Check if a [Material] is a tool.
 *
 * @return Whether the [Material] is a tool.
 */
val Material.isTool: Boolean
    get() = isPickaxe || isAxe || isSpade || isHoe

/**
 * Check if a [Material] is a weapon.
 *
 * @return Whether the [Material] is a weapon.
 */
val Material.isWeapon: Boolean
    get() = this == Material.BOW || isSword

/**
 * Check if a [Material] is farmable.
 *
 * @return Whether the [Material] is farmable.
 */
val Material.isFarmable: Boolean
    get() = when (this) {
        Material.WHEAT,
        Material.POTATO,
        Material.NETHER_WARTS,
        Material.CARROT -> true
        else -> false
    }

/**
 * Check if a [Material] is an ore.
 *
 * @return Whether the [Material] is an ore.
 */
val Material.isOre: Boolean
    get() = when (this) {
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.LAPIS_ORE,
        Material.REDSTONE_ORE -> true
        else -> false
    }

/**
 * Check if a [Material] is a soft block.
 *
 * @return Whether the [Material] is a soft block.
 */
val Material.isSoft: Boolean
    get() = when (this) {
        Material.SAND,
        Material.GRAVEL,
        Material.DIRT,
        Material.SOUL_SAND,
        Material.GRASS,
        Material.CLAY -> true
        else -> false
    }

/**
 * Check if a [Material] is a chest.
 *
 * @return Whether the [Material] is a chest.
 */
val Material.isChest: Boolean
    get() = when (this) {
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST -> true
        else -> false
    }

/**
 * Check if a [Material] is a container.
 *
 * @return Whether the [Material] is a container.
 */
val Material.isContainer: Boolean
    get() = when (this) {
        Material.CHEST,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.FURNACE,
        Material.BREWING_STAND,
        Material.DISPENSER,
        Material.DROPPER,
        Material.HOPPER -> true
        else -> false
    }

/**
 * Check if a [Material] is a station.
 *
 * @return Whether the [Material] is a station.
 */
val Material.isStation: Boolean
    get() = when (this) {
        Material.FURNACE,
        Material.ENCHANTMENT_TABLE,
        Material.BREWING_STAND,
        Material.CAULDRON,
        Material.CHEST,
        Material.DISPENSER,
        Material.DROPPER,
        Material.JUKEBOX,
        Material.ENDER_CHEST,
        Material.TRAPPED_CHEST,
        Material.HOPPER -> true
        else -> false
    }

/**
 * Check if a [Material] is liquid.
 *
 * @return Whether the [Material] is a liquid.
 */
val Material.isLiquid: Boolean
    get() = when (this) {
        Material.WATER,
        Material.STATIONARY_WATER,
        Material.LAVA,
        Material.STATIONARY_LAVA -> true
        else -> false
    }

/**
 * Check if a [Material] is a plant.
 *
 * @return Whether the [Material] is a plant.
 */
val Material.isPlant: Boolean
    get() = when (this) {
        Material.LONG_GRASS,
        Material.YELLOW_FLOWER,
        Material.CACTUS,
        Material.DEAD_BUSH,
        Material.DOUBLE_PLANT -> true
        else -> false
    }

/**
 * Check if a [Material] is a gem.
 *
 * @return Whether the [Material] is a gem.
 */
val Material.isGem: Boolean
    get() = when (this) {
        Material.IRON_INGOT,
        Material.GOLD_INGOT,
        Material.DIAMOND,
        Material.EMERALD,
        Material.REDSTONE,
        Material.QUARTZ,
        Material.COAL,
        Material.LAPIS_BLOCK,
        Material.GOLD_NUGGET -> true
        else -> false
    }

/**
 * Check if a [Material] can be used as fuel.
 *
 * @return Whether the [Material] can be used as fuel.
 */
val Material.isFuel: Boolean
    get() = when (this) {
        Material.WOOD_SPADE,
        Material.WOOD,
        Material.WOODEN_DOOR,
        Material.WOOD_AXE,
        Material.WOOD_BUTTON,
        Material.WOOD_DOUBLE_STEP,
        Material.WOOD_HOE,
        Material.WOOD_PICKAXE,
        Material.WOOD_PLATE,
        Material.WOOD_STAIRS,
        Material.WOOD_STEP,
        Material.WOOD_SWORD,
        Material.BIRCH_WOOD_STAIRS,
        Material.JUNGLE_WOOD_STAIRS,
        Material.SPRUCE_WOOD_STAIRS,
        Material.COAL,
        Material.COAL_BLOCK,
        Material.LAVA_BUCKET,
        Material.BLAZE_ROD,
        Material.BOAT,
        Material.LOG,
        Material.LOG_2,
        Material.FENCE,
        Material.ACACIA_FENCE,
        Material.BIRCH_FENCE,
        Material.DARK_OAK_FENCE,
        Material.JUNGLE_FENCE,
        Material.SPRUCE_FENCE,
        Material.FENCE_GATE,
        Material.ACACIA_FENCE_GATE,
        Material.BIRCH_FENCE_GATE,
        Material.DARK_OAK_FENCE_GATE,
        Material.JUNGLE_FENCE_GATE,
        Material.SPRUCE_FENCE_GATE,
        Material.ACACIA_STAIRS,
        Material.DARK_OAK_STAIRS,
        Material.TRAP_DOOR,
        Material.WORKBENCH,
        Material.BOOKSHELF,
        Material.CHEST,
        Material.TRAPPED_CHEST,
        Material.DAYLIGHT_DETECTOR,
        Material.DAYLIGHT_DETECTOR_INVERTED,
        Material.JUKEBOX,
        Material.NOTE_BLOCK,
        Material.BROWN_MUSHROOM,
        Material.HUGE_MUSHROOM_1,
        Material.HUGE_MUSHROOM_2,
        Material.RED_MUSHROOM,
        Material.BANNER,
        Material.STANDING_BANNER,
        Material.WALL_BANNER,
        Material.BOW,
        Material.FISHING_ROD,
        Material.LADDER,
        Material.SIGN,
        Material.SIGN_POST,
        Material.WALL_SIGN,
        Material.ACACIA_DOOR,
        Material.BIRCH_DOOR,
        Material.DARK_OAK_DOOR,
        Material.JUNGLE_DOOR,
        Material.SPRUCE_DOOR,
        Material.SAPLING,
        Material.STICK,
        Material.WOOL,
        Material.CARPET -> true
        else -> false
    }

/**
 * Check if a [Material] is smeltable.
 *
 * @return Whether the [Material] is smeltable.
 */
val Material.isSmeltable: Boolean
    get() = when (this) {
        Material.RAW_BEEF,
        Material.RAW_CHICKEN,
        Material.RAW_FISH,
        Material.POTATO,
        Material.MUTTON,
        Material.RABBIT,
        Material.IRON_ORE,
        Material.GOLD_ORE,
        Material.COAL_ORE,
        Material.DIAMOND_ORE,
        Material.EMERALD_ORE,
        Material.GLOWING_REDSTONE_ORE,
        Material.LAPIS_ORE,
        Material.QUARTZ_ORE,
        Material.REDSTONE_ORE,
        Material.SAND,
        Material.COBBLESTONE,
        Material.SANDSTONE,
        Material.RED_SANDSTONE,
        Material.CLAY_BALL,
        Material.NETHERRACK,
        Material.NETHER_BRICK,
        Material.CLAY,
        Material.BRICK,
        Material.CACTUS,
        Material.LOG,
        Material.LOG_2,
        Material.WOOD -> true
        else -> false
    }

/**
 * Check if a [Material] is smelted.
 *
 * @return Whether the [Material] is smelted.
 */
val Material.isSmelted: Boolean
    get() = when (this) {
        Material.COOKED_BEEF,
        Material.COOKED_CHICKEN,
        Material.COOKED_FISH,
        Material.BAKED_POTATO,
        Material.COOKED_MUTTON,
        Material.COOKED_RABBIT,
        Material.IRON_INGOT,
        Material.GOLD_INGOT,
        Material.COAL,
        Material.DIAMOND,
        Material.EMERALD,
        Material.REDSTONE,
        Material.LAPIS_BLOCK,
        Material.QUARTZ,
        Material.GLASS,
        Material.STONE,
        Material.BRICK,
        Material.NETHER_BRICK_ITEM,
        Material.NETHER_BRICK,
        Material.SPONGE -> true
        else -> false
    }

/**
 * Check if a [Material] is cooked.
 *
 * @return Whether the [Material] is cooked.
 */
val Material.isCooked: Boolean
    get() = when (this) {
        Material.COOKED_BEEF,
        Material.COOKED_CHICKEN,
        Material.COOKED_FISH,
        Material.BAKED_POTATO,
        Material.COOKED_MUTTON,
        Material.COOKED_RABBIT -> true
        else -> false
    }

/**
 * Check if a [Material] is a fence.
 *
 * @return Whether the [Material] is a fence.
 */
val Material.isFence: Boolean
    get() = when (this) {
        Material.FENCE,
        Material.SPRUCE_FENCE,
        Material.NETHER_FENCE,
        Material.JUNGLE_FENCE,
        Material.DARK_OAK_FENCE,
        Material.BIRCH_FENCE,
        Material.ACACIA_FENCE,
        Material.IRON_FENCE -> true
        else -> false
    }

/**
 * Check if a [Material] is a fence gate.
 *
 * @return Whether the [Material] is a fence gate.
 */
val Material.isFenceGate: Boolean
    get() = when (this) {
        Material.FENCE_GATE,
        Material.SPRUCE_FENCE_GATE,
        Material.JUNGLE_FENCE_GATE,
        Material.DARK_OAK_FENCE_GATE,
        Material.BIRCH_FENCE_GATE,
        Material.ACACIA_FENCE_GATE -> true
        else -> false
    }

/**
 * Check if a [Material] is stairs.
 *
 * @return Whether the [Material] is stairs.
 */
val Material.isStairs: Boolean
    get() = when (this) {
        Material.WOOD_STAIRS,
        Material.SPRUCE_WOOD_STAIRS,
        Material.NETHER_BRICK_STAIRS,
        Material.JUNGLE_WOOD_STAIRS,
        Material.DARK_OAK_STAIRS,
        Material.BIRCH_WOOD_STAIRS,
        Material.ACACIA_STAIRS -> true
        else -> false
    }

/**
 * Check if a [Material] is a door.
 *
 * @return Whether the [Material] is a door.
 */
val Material.isDoor: Boolean
    get() = when (this) {
        Material.WOOD_DOOR,
        Material.SPRUCE_DOOR,
        Material.JUNGLE_DOOR,
        Material.DARK_OAK_DOOR,
        Material.BIRCH_DOOR,
        Material.ACACIA_DOOR -> true
        else -> false
    }

/**
 * Check if a [Material] is a trapdoor.
 *
 * @return Whether the [Material] is a trapdoor.
 */
val Material.isTrapdoor: Boolean
    get() = when (this) {
        Material.TRAP_DOOR,
        Material.IRON_TRAPDOOR -> true
        else -> false
    }

/**
 * Check if a [Material] is an armor piece.
 *
 * @return Whether the [Material] is a armor piece.
 */
val Material.isArmor: Boolean
    get() = when (this) {
        Material.LEATHER_LEGGINGS,
        Material.CHAINMAIL_LEGGINGS,
        Material.IRON_LEGGINGS,
        Material.GOLD_LEGGINGS,
        Material.DIAMOND_LEGGINGS,
        Material.LEATHER_BOOTS,
        Material.CHAINMAIL_BOOTS,
        Material.IRON_BOOTS,
        Material.GOLD_BOOTS,
        Material.DIAMOND_BOOTS,
        Material.LEATHER_CHESTPLATE,
        Material.CHAINMAIL_CHESTPLATE,
        Material.IRON_CHESTPLATE,
        Material.GOLD_CHESTPLATE,
        Material.DIAMOND_CHESTPLATE,
        Material.LEATHER_HELMET,
        Material.CHAINMAIL_HELMET,
        Material.IRON_HELMET,
        Material.GOLD_HELMET,
        Material.DIAMOND_HELMET -> true
        else -> false
    }

/**
 * Check if a [Material] is leggings.
 *
 * @return Whether the [Material] is leggings.
 */
val Material.isLeggings: Boolean
    get() = when (this) {
        Material.LEATHER_LEGGINGS,
        Material.CHAINMAIL_LEGGINGS,
        Material.IRON_LEGGINGS,
        Material.GOLD_LEGGINGS,
        Material.DIAMOND_LEGGINGS -> true
        else -> false
    }

/**
 * Check if a [Material] is boots.
 *
 * @return Whether the [Material] is boots.
 */
val Material.isBoots: Boolean
    get() = when (this) {
        Material.LEATHER_BOOTS,
        Material.CHAINMAIL_BOOTS,
        Material.IRON_BOOTS,
        Material.GOLD_BOOTS,
        Material.DIAMOND_BOOTS -> true
        else -> false
    }

/**
 * Check if a [Material] is a chestplate.
 *
 * @return Whether the [Material] is a chestplate.
 */
val Material.isChestplate: Boolean
    get() = when (this) {
        Material.LEATHER_CHESTPLATE,
        Material.CHAINMAIL_CHESTPLATE,
        Material.IRON_CHESTPLATE,
        Material.GOLD_CHESTPLATE,
        Material.DIAMOND_CHESTPLATE -> true
        else -> false
    }

/**
 * Check if a [Material] is a helmet.
 *
 * @return Whether the [Material] is a helmet.
 */
val Material.isHelmet: Boolean
    get() = when (this) {
        Material.LEATHER_HELMET,
        Material.CHAINMAIL_HELMET,
        Material.IRON_HELMET,
        Material.GOLD_HELMET,
        Material.DIAMOND_HELMET -> true
        else -> false
    }

/**
 * Check if a [Material] is brewing ingredient.
 *
 * @return Whether the [Material] is brewing ingredient.
 */
val Material.isBrewingIngredient: Boolean
    get() = when (this) {
        Material.NETHER_WARTS,
        Material.REDSTONE,
        Material.GLOWSTONE_DUST,
        Material.FERMENTED_SPIDER_EYE,
        Material.SUGAR,
        Material.RABBIT_FOOT,
        Material.SPECKLED_MELON,
        Material.SPIDER_EYE,
        Material.MAGMA_CREAM,
        Material.GOLDEN_CARROT,
        Material.BLAZE_POWDER,
        Material.GHAST_TEAR,
        Material.SULPHUR -> true
        else -> false
    }

/**
 * Check if a [Material] is placeable.
 *
 * @return Whether the [Material] is placeable.
 */
val Material.isPlaceable: Boolean
    get() = when (this) {
        Material.STONE,
        Material.GRASS,
        Material.DIRT,
        Material.COBBLESTONE,
        Material.WOOD,
        Material.SAPLING,
        Material.BEDROCK,
        Material.WATER,
        Material.STATIONARY_WATER,
        Material.LAVA,
        Material.STATIONARY_LAVA,
        Material.SAND,
        Material.GRAVEL,
        Material.GOLD_ORE,
        Material.IRON_ORE,
        Material.COAL_ORE,
        Material.LOG,
        Material.LEAVES,
        Material.SPONGE,
        Material.GLASS,
        Material.LAPIS_ORE,
        Material.LAPIS_BLOCK,
        Material.DISPENSER,
        Material.SANDSTONE,
        Material.NOTE_BLOCK,
        Material.BED_BLOCK,
        Material.POWERED_RAIL,
        Material.DETECTOR_RAIL,
        Material.PISTON_STICKY_BASE,
        Material.WEB,
        Material.LONG_GRASS,
        Material.DEAD_BUSH,
        Material.PISTON_BASE,
        Material.PISTON_EXTENSION,
        Material.WOOL,
        Material.PISTON_MOVING_PIECE,
        Material.YELLOW_FLOWER,
        Material.RED_ROSE,
        Material.BROWN_MUSHROOM,
        Material.RED_MUSHROOM,
        Material.GOLD_BLOCK,
        Material.IRON_BLOCK,
        Material.DOUBLE_STEP,
        Material.STEP,
        Material.BRICK,
        Material.TNT,
        Material.BOOKSHELF,
        Material.MOSSY_COBBLESTONE,
        Material.OBSIDIAN,
        Material.TORCH,
        Material.FIRE,
        Material.MOB_SPAWNER,
        Material.WOOD_STAIRS,
        Material.CHEST,
        Material.REDSTONE_WIRE,
        Material.DIAMOND_ORE,
        Material.DIAMOND_BLOCK,
        Material.WORKBENCH,
        Material.SOIL,
        Material.FURNACE,
        Material.BURNING_FURNACE,
        Material.SIGN_POST,
        Material.WOODEN_DOOR,
        Material.LADDER,
        Material.RAILS,
        Material.COBBLESTONE_STAIRS,
        Material.WALL_SIGN,
        Material.LEVER,
        Material.STONE_PLATE,
        Material.IRON_DOOR_BLOCK,
        Material.WOOD_PLATE,
        Material.REDSTONE_ORE,
        Material.GLOWING_REDSTONE_ORE,
        Material.REDSTONE_TORCH_OFF,
        Material.REDSTONE_TORCH_ON,
        Material.STONE_BUTTON,
        Material.SNOW,
        Material.ICE,
        Material.SNOW_BLOCK,
        Material.CACTUS,
        Material.CLAY,
        Material.SUGAR_CANE_BLOCK,
        Material.JUKEBOX,
        Material.FENCE,
        Material.PUMPKIN,
        Material.NETHERRACK,
        Material.SOUL_SAND,
        Material.GLOWSTONE,
        Material.PORTAL,
        Material.JACK_O_LANTERN,
        Material.CAKE_BLOCK,
        Material.DIODE_BLOCK_OFF,
        Material.DIODE_BLOCK_ON,
        Material.STAINED_GLASS,
        Material.TRAP_DOOR,
        Material.MONSTER_EGGS,
        Material.SMOOTH_BRICK,
        Material.HUGE_MUSHROOM_1,
        Material.HUGE_MUSHROOM_2,
        Material.IRON_FENCE,
        Material.THIN_GLASS,
        Material.MELON_BLOCK,
        Material.PUMPKIN_STEM,
        Material.MELON_STEM,
        Material.VINE,
        Material.FENCE_GATE,
        Material.BRICK_STAIRS,
        Material.SMOOTH_STAIRS,
        Material.MYCEL,
        Material.WATER_LILY,
        Material.NETHER_BRICK,
        Material.NETHER_FENCE,
        Material.NETHER_BRICK_STAIRS,
        Material.NETHER_WARTS,
        Material.ENCHANTMENT_TABLE,
        Material.BREWING_STAND,
        Material.CAULDRON,
        Material.ENDER_PORTAL,
        Material.ENDER_PORTAL_FRAME,
        Material.ENDER_STONE,
        Material.DRAGON_EGG,
        Material.REDSTONE_LAMP_OFF,
        Material.REDSTONE_LAMP_ON,
        Material.WOOD_DOUBLE_STEP,
        Material.WOOD_STEP,
        Material.COCOA,
        Material.SANDSTONE_STAIRS,
        Material.EMERALD_ORE,
        Material.ENDER_CHEST,
        Material.TRIPWIRE_HOOK,
        Material.TRIPWIRE,
        Material.EMERALD_BLOCK,
        Material.SPRUCE_WOOD_STAIRS,
        Material.BIRCH_WOOD_STAIRS,
        Material.JUNGLE_WOOD_STAIRS,
        Material.COMMAND,
        Material.BEACON,
        Material.COBBLE_WALL,
        Material.FLOWER_POT,
        Material.CARROT,
        Material.POTATO,
        Material.WOOD_BUTTON,
        Material.SKULL,
        Material.ANVIL,
        Material.TRAPPED_CHEST,
        Material.GOLD_PLATE,
        Material.IRON_PLATE,
        Material.REDSTONE_COMPARATOR_OFF,
        Material.REDSTONE_COMPARATOR_ON,
        Material.DAYLIGHT_DETECTOR,
        Material.REDSTONE_BLOCK,
        Material.QUARTZ_ORE,
        Material.HOPPER,
        Material.QUARTZ_BLOCK,
        Material.QUARTZ_STAIRS,
        Material.ACTIVATOR_RAIL,
        Material.DROPPER,
        Material.STAINED_CLAY,
        Material.STAINED_GLASS_PANE,
        Material.LEAVES_2,
        Material.LOG_2,
        Material.ACACIA_STAIRS,
        Material.DARK_OAK_STAIRS,
        Material.SLIME_BLOCK,
        Material.BARRIER,
        Material.IRON_TRAPDOOR,
        Material.PRISMARINE,
        Material.SEA_LANTERN,
        Material.HAY_BLOCK,
        Material.CARPET,
        Material.HARD_CLAY,
        Material.COAL_BLOCK,
        Material.PACKED_ICE,
        Material.DOUBLE_PLANT,
        Material.STANDING_BANNER,
        Material.WALL_BANNER,
        Material.DAYLIGHT_DETECTOR_INVERTED,
        Material.RED_SANDSTONE,
        Material.RED_SANDSTONE_STAIRS,
        Material.DOUBLE_STONE_SLAB2,
        Material.STONE_SLAB2,
        Material.SPRUCE_FENCE_GATE,
        Material.BIRCH_FENCE_GATE,
        Material.JUNGLE_FENCE_GATE,
        Material.DARK_OAK_FENCE_GATE,
        Material.ACACIA_FENCE_GATE,
        Material.SPRUCE_FENCE,
        Material.BIRCH_FENCE,
        Material.JUNGLE_FENCE,
        Material.DARK_OAK_FENCE,
        Material.ACACIA_FENCE,
        Material.SPRUCE_DOOR,
        Material.BIRCH_DOOR,
        Material.JUNGLE_DOOR,
        Material.ACACIA_DOOR,
        Material.DARK_OAK_DOOR,
        Material.STRING,
        Material.SEEDS,
        Material.WHEAT,
        Material.PAINTING,
        Material.SIGN,
        Material.WOOD_DOOR,
        Material.WATER_BUCKET,
        Material.LAVA_BUCKET,
        Material.MINECART,
        Material.SADDLE,
        Material.IRON_DOOR,
        Material.REDSTONE,
        Material.BOAT,
        Material.CLAY_BRICK,
        Material.SUGAR_CANE,
        Material.SLIME_BALL,
        Material.STORAGE_MINECART,
        Material.POWERED_MINECART,
        Material.EGG,
        Material.GLOWSTONE_DUST,
        Material.CAKE,
        Material.BED,
        Material.DIODE,
        Material.MELON,
        Material.PUMPKIN_SEEDS,
        Material.MELON_SEEDS,
        Material.ENDER_PEARL,
        Material.NETHER_STALK,
        Material.MONSTER_EGG,
        Material.ITEM_FRAME,
        Material.FLOWER_POT_ITEM,
        Material.SKULL_ITEM,
        Material.REDSTONE_COMPARATOR,
        Material.EXPLOSIVE_MINECART,
        Material.HOPPER_MINECART,
        Material.ARMOR_STAND,
        Material.COMMAND_MINECART,
        Material.BANNER,
        Material.SPRUCE_DOOR_ITEM,
        Material.BIRCH_DOOR_ITEM,
        Material.JUNGLE_DOOR_ITEM,
        Material.ACACIA_DOOR_ITEM,
        Material.DARK_OAK_DOOR_ITEM -> true
        else -> false
    }
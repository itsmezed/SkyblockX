package io.illyria.skyblockx.persist

import io.illyria.skyblockx.quest.Quest
import io.illyria.skyblockx.quest.QuestGoal
import net.prosavage.baseplugin.XMaterial
import net.prosavage.baseplugin.serializer.Serializer
import net.prosavage.baseplugin.serializer.commonobjects.SerializableItem
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.EntityType

object Quests {
    @Transient
    private val instance = this

    var islandQuestGUITitle = "&bIsland Quests"

    var islandQuestGUIBackgroundItem = SerializableItem(XMaterial.BLACK_STAINED_GLASS_PANE, "&9", listOf(), 1)

    var islandQuestGUIRows: Int = 3

    var questOrder = listOf(
        "Quest-1",
        "Quest-2"
    )

    var useQuestOrder = true
    var sendNextQuestInOrderMessages = true

    var islandQuests = listOf(
        Quest(
            "Quest-1",
            "Get wood from your island's tree",
            SerializableItem(
                XMaterial.OAK_WOOD,
                "&bGet wood from island's tree",
                listOf(
                    "&7Break the wood from your island's tree trunk",
                    "&7Completion: &b{currentAmount}&7/&b{finalAmount}"
                ),
                1
            ),
            14,
            QuestGoal.BREAK_BLOCKS,
            XMaterial.OAK_LOG.name,
            1,
            true,
            listOf("broadcast {player} broke wood from island tree", "give {player} oak_sapling 1")
        ),
        Quest(
            "Quest-2",
            "Craft wooden planks",
            SerializableItem(
                XMaterial.OAK_PLANKS,
                "&bCraft some wooden planks",
                listOf("&7Put a log in a crafting table", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            15,
            QuestGoal.CRAFT,
            XMaterial.OAK_PLANKS.name,
            1,
            true,
            listOf("broadcast {player} crafted wooden planks", "give {player} oak_sapling 1")
        ),
        Quest(
            "Quest-1",
            "Get wood from your island's tree",
            SerializableItem(
                XMaterial.OAK_WOOD,
                "&bGet wood from island's tree",
                listOf(
                    "&7Break the wood from your island's tree trunk",
                    "&7Completion: &b{currentAmount}&7/&b{finalAmount}"
                ),
                1
            ),
            14,
            QuestGoal.BREAK_BLOCKS,
            XMaterial.OAK_LOG.name,
            1,
            false,
            listOf("broadcast {player} broke wood from island tree", "give {player} oak_sapling 1")
        ),
        Quest(
            "MCobble-1",
            "Mine-Cobblestone-1",
            SerializableItem(
                XMaterial.COBBLESTONE,
                "&8Mine-Cobblestone (Tier 1)",
                listOf("&7Mine &b10 &7cobblestone", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            0,
            QuestGoal.BREAK_BLOCKS,
            XMaterial.COBBLESTONE.name,
            10,
            false,
            listOf("broadcast {player} completed the Tier 1 Cobblestone Mining Quest.", "give {player} diamond 1")
        ),
        Quest(
            "MCobble-2",
            "Mine-Cobblestone-2",
            SerializableItem(
                XMaterial.COBBLESTONE,
                "&8Mine-Cobblestone (Tier 2)",
                listOf("&7Mine &b100,000 &7cobblestone", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            1,
            QuestGoal.BREAK_BLOCKS,
            XMaterial.COBBLESTONE.name,
            100000,
            false,
            listOf("broadcast {player} completed the Tier 2 Cobblestone Mining Quest.", "give {player} diamond 1")
        ),
        Quest(
            "MCobble-3",
            "Mine-Cobblestone-3",
            SerializableItem(
                XMaterial.COBBLESTONE,
                "&8Mine-Cobblestone (Tier 3)",
                listOf("&7Mine &b1,000,000 &7cobblestone", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            2,
            QuestGoal.BREAK_BLOCKS,
            XMaterial.COBBLESTONE.name,
            1000000,
            false,
            listOf("broadcast {player} completed the Tier 3 Cobblestone Mining Quest.", "give {player} diamond 1")
        ),
        Quest(
            "KCreeper-1",
            "Kill-Creeper-1",
            SerializableItem(
                XMaterial.CREEPER_SPAWN_EGG,
                "&8Kill Creepers (Tier 1)",
                listOf("&7Kill &b10 &7creepers", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            3,
            QuestGoal.KILL_MOBS,
            EntityType.CREEPER.name,
            10,
            false,
            listOf("broadcast {player} completed the Tier 1 Creeper Killing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "KCreeper-2",
            "Kill-Creeper-2",
            SerializableItem(
                XMaterial.CREEPER_SPAWN_EGG,
                "&8Kill Creepers (Tier 2)",
                listOf("&7Kill &b100 &7creepers", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            4,
            QuestGoal.KILL_MOBS,
            EntityType.CREEPER.name,
            100,
            false,
            listOf("broadcast {player} completed the Tier 2 Creeper Killing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "KCreeper-3",
            "Kill-Creeper-3",
            SerializableItem(
                XMaterial.CREEPER_SPAWN_EGG,
                "&8Kill Creepers (Tier 3)",
                listOf("&7Kill &b1,000 &7creepers", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            5,
            QuestGoal.KILL_MOBS,
            EntityType.CREEPER.name,
            1000,
            false,
            listOf("broadcast {player} completed the Tier 3 Creeper Killing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "CDiamondP-1",
            "Craft-Diamond-Pickaxe-1",
            SerializableItem(
                XMaterial.DIAMOND_PICKAXE,
                "&8Craft Diamond Pickaxe (Tier 1)",
                listOf("&7Craft &b1 &7Diamond Pickaxe", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            6,
            QuestGoal.CRAFT,
            XMaterial.DIAMOND_PICKAXE.name,
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Diamond Pickaxe Quest.", "give {player} diamond 1")
        ),
        Quest(
            "CDiamondS-1",
            "Craft-Diamond-Sword-1",
            SerializableItem(
                XMaterial.DIAMOND_SWORD,
                "&8Craft Diamond Sword (Tier 1)",
                listOf("&7Craft &b1 &7Diamond Sword", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            7,
            QuestGoal.CRAFT,
            XMaterial.DIAMOND_SWORD.name,
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Diamond Sword Quest.", "give {player} diamond 1")
        ),
        Quest(
            "CDiamondShovel-1",
            "Craft-Diamond-Shovel-1",
            SerializableItem(
                XMaterial.DIAMOND_SHOVEL,
                "&8Craft Diamond Shovel (Tier 1)",
                listOf("&7Craft &b1 &7Diamond Shovel", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            8,
            QuestGoal.CRAFT,
            XMaterial.DIAMOND_SHOVEL.name,
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Diamond Shovel Quest.", "give {player} diamond 1")
        ),
        Quest(
            "FSalmon-1",
            "Fish-Salmon-1",
            SerializableItem(
                XMaterial.SALMON,
                "&8Fish for Salmon (Tier 1)",
                listOf("&7Fish for &b1 &7Salmon", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            9,
            QuestGoal.FISHING,
            EntityType.SALMON.name,
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Salmon Fishing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "FSalmon-2",
            "Fish-Salmon-2",
            SerializableItem(
                XMaterial.SALMON,
                "&8Fish for Salmon (Tier 2)",
                listOf("&7Fish for &b10 &7Salmon", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            10,
            QuestGoal.FISHING,
            EntityType.SALMON.name,
            10,
            false,
            listOf("broadcast {player} completed the Tier 2 Salmon Fishing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "FSalmon-3",
            "Fish-Salmon-3",
            SerializableItem(
                XMaterial.SALMON,
                "&8Fish for Salmon (Tier 3)",
                listOf("&7Fish for &b100 &7Salmon", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            11,
            QuestGoal.FISHING,
            EntityType.SALMON.name,
            100,
            false,
            listOf("broadcast {player} completed the Tier 3 Salmon Fishing Quest.", "give {player} diamond 1")
        ),
        Quest(
            "ESharp-1",
            "Sharpness-1",
            SerializableItem(
                XMaterial.ENCHANTED_BOOK,
                "&8Sharpness 1",
                listOf("&7Enchant a book for sharpness 1", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            12,
            QuestGoal.ENCHANT,
            "${Enchantment.DAMAGE_ALL.name}=1",
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Sharpness 1 Enchanting Quest.", "give {player} diamond 1")
        ),
        Quest(
            "RBow-1",
            "Repair-1",
            SerializableItem(
                XMaterial.ANVIL,
                "&8Repair A Bow",
                listOf("&7Repair a broken bow using an anvil.", "&7Completion: &b{currentAmount}&7/&b{finalAmount}"),
                1
            ),
            13,
            QuestGoal.REPAIR,
            XMaterial.BOW.parseMaterial()!!.name,
            1,
            false,
            listOf("broadcast {player} completed the Tier 1 Bow Repair Quest.", "give {player} diamond 1")
        )

    )

    fun save() {
        Serializer().save(instance)
    }

    fun load() {
        Serializer().load(instance, Quests::class.java, "quests")
    }
}
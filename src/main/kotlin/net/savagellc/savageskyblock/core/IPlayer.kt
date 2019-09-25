package net.savagellc.savageskyblock.core

import net.savagellc.savageskyblock.persist.Config
import net.savagellc.savageskyblock.persist.Data
import net.savagellc.savageskyblock.sedit.Position
import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.entity.Player
import java.util.*

data class IPlayer(val uuid: String) {


    var inBypass = false

    var falling = false

    var islandID = -1
    var tag = Bukkit.getOfflinePlayer(UUID.fromString(uuid)).name

    var choosingPosition = false
    var chosenPosition = Position.POSITION1


    var coopedIslandIds = arrayListOf<Int>()

    @Transient
    var pos1: Location? = null
    @Transient
    var pos2: Location? = null

    fun getPlayer(): Player {
        return Bukkit.getPlayer(UUID.fromString(uuid))!!
    }


    fun isOnOwnIsland(): Boolean {
        return !(this.hasIsland() && this.getIsland()!!.containsBlock(getPlayer().location))
    }

    fun message(message: String) {
        getPlayer().sendMessage(color(message))
    }

    fun removeCoopIsland(id: Int) {
        coopedIslandIds.remove(id)
    }

    fun removeCoopIsland(island: Island) {
        coopedIslandIds.remove(island.islandID)
    }

    fun addCoopIsland(island: Island) {
        coopedIslandIds.add(island.islandID)
    }

    fun getCoopIslands(): List<Island> {
        val islands = arrayListOf<Island>()
        coopedIslandIds.forEach { id -> islands.add(Data.islands[id]!!) }
        return islands
    }

    fun hasCoopIsland(): Boolean {
        return coopedIslandIds.isNotEmpty()
    }

    fun hasIsland(): Boolean {
        return islandID != -1 && Data.islands.containsKey(islandID)
    }

    fun unassignIsland() {
        islandID = -1
    }

    fun assignIsland(island: Island) {
        islandID = island.islandID
    }

    fun assignIsland(islandID: Int) {
        this.islandID = islandID
    }

    fun getIsland(): Island? {
        return Data.islands[islandID]
    }

    fun coopPlayer(iPlayer: IPlayer) {
        // the iplayer needs an island for this.
        iPlayer.coopedIslandIds.add(getIsland()!!.islandID)
    }

    fun coopIslandsContainBlock(location: Location): Boolean {
        for (id in coopedIslandIds) {
            // Island was not found, continue to next island.
            val island = Data.islands[id] ?: continue
            if (!island.containsBlock(location)) {
                return false
            }
        }
        return true
    }


}

fun getIPlayer(player: Player): IPlayer {
    if (Data.IPlayers.containsKey(player.uniqueId.toString())) {
        return Data.IPlayers[player.uniqueId.toString()]!!
    }
    // The IPlayer instance does not exist, create it.
    val iPlayer = IPlayer(player.uniqueId.toString())
    Data.IPlayers[player.uniqueId.toString()] = iPlayer
    return iPlayer
}


fun canUseBlockAtLocation(iPlayer: IPlayer, location: Location): Boolean {
    // If the world is not the skyblock world, we will not interfere.
    if (location.world!!.name.equals(Config.skyblockWorldName)) return true
    // If they dont have any co-op island or an island of their own, then they cannot do anything.
    if (!iPlayer.hasIsland() && !iPlayer.hasCoopIsland()) return false
    // Check our own island.
    var cancelEvent = (iPlayer.hasIsland() && !iPlayer.getIsland()!!.containsBlock(location))
    // Check the co-op island's permission if our own island's permission have failed.
    if (cancelEvent && iPlayer.hasCoopIsland()) {
        cancelEvent = (iPlayer.hasCoopIsland() && !iPlayer.coopIslandsContainBlock(location))
    }
    return !cancelEvent
}
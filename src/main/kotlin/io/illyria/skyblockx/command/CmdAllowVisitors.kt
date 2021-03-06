package io.illyria.skyblockx.command

import io.illyria.skyblockx.core.Permission
import io.illyria.skyblockx.persist.Message

class CmdAllowVisitors : SCommand() {

    init {
        aliases.add("allow-visitors")
        aliases.add("visitors")

        this.optionalArgs.add(Argument("toggle", 0, BooleanArgument()))
        commandRequirements = CommandRequirementsBuilder().withPermission(Permission.ALLOWVISITOR).asIslandMember(true).asLeader(true).build()
    }

    override fun perform(info: CommandInfo) {
        if (info.args.size == 1) {
            val argAsBoolean = info.getArgAsBoolean(0) ?: return
            info.island!!.allowVisitors = argAsBoolean
        }
        info.island!!.allowVisitors = !info.island!!.allowVisitors
        info.message(String.format(Message.commandAllowVisitorsStatus, info.island!!.allowVisitors))
    }

    override fun getHelpInfo(): String {
        return Message.commandAllowVisitorsHelp
    }
}
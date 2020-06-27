package io.arct.arctcore.commands

import io.arct.arctlib.extensions.unaryPlus
import io.arct.arctlib.plugin.commands.Command
import io.arct.arctlib.plugin.commands.Run
import org.bukkit.command.CommandSender
import javax.script.ScriptEngineManager

class CommandScript : Command("script") {
    override val permissions = listOf("arctcore.script")

    private val data: MutableMap<CommandSender, List<String>> = mutableMapOf()

    @Run
    fun run(sender: CommandSender, args: List<String>) {
        if (args.isEmpty()) {
            sender.sendMessage(+"&4Error: &cInvalid arguments")
            return
        }

        when (args[0]) {
            "start" -> start(sender)
            "reset" -> reset(sender)
            "remove" -> remove(sender, args.drop(1))
            "run", "execute" -> execute(sender)
        }

        add(sender, args.drop(1))
    }

    private fun start(sender: CommandSender) {
        if (sender in data) {
            sender.sendMessage(+"&4Error: &cScript has already started")
            return
        }

        data[sender] = listOf()
    }

    private fun reset(sender: CommandSender) {
        if (sender !in data) {
            sender.sendMessage(+"&4Error: &cScript does not exist")
            return
        }

        data[sender] = listOf()
    }

    private fun add(sender: CommandSender, args: List<String>) {
        if (sender !in data) {
            sender.sendMessage(+"&4Error: &cScript does not exist")
            return
        }

        data[sender] = data[sender]!! + listOf(args.joinToString(" "))
    }

    private fun remove(sender: CommandSender, args: List<String>) {
        if (sender !in data) {
            sender.sendMessage(+"&4Error: &cScript does not exist")
            return
        }

        var count: Int = if (args.isEmpty()) 1 else args[0].toIntOrNull() ?: 1

        if (count > data[sender]!!.size)
            count = data[sender]!!.size

        data[sender] = data[sender]!!.dropLast(count)
    }

    private fun execute(sender: CommandSender) {
        if (sender !in data) {
            sender.sendMessage(+"&4Error: &cScript does not exist")
            return
        }

        sender.sendMessage(+"Evaluating Script:")
        for ((index, line) in data[sender]!!.withIndex())
            sender.sendMessage(+"&7$index |&r" + line)

        val lines = data[sender]!!.joinToString("\n")

        sender.sendMessage(+"Result:")

        with (ScriptEngineManager().getEngineByExtension("kts")) {
            val result = eval(lines)

            if (result == null)
                sender.sendMessage("null")
            else
                sender.sendMessage(result.toString())
        }
    }
}
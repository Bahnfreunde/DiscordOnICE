package space.bahnfreunde

import io.github.cdimascio.dotenv.dotenv
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.requests.GatewayIntent
import space.bahnfreunde.events.Ready

class Main {
    companion object {
        val dotenv = dotenv()
    }
}

fun main(args: Array<String>) {
    val jda = JDABuilder.createDefault(Main.dotenv["TOKEN"])
        .addEventListeners(Ready()).build()
}
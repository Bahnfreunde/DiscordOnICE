package space.bahnfreunde.verify

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import space.bahnfreunde.Main
import java.net.URL

class Verification : ListenerAdapter() {
    private val verificationCodes: MutableMap<String, User> = HashMap()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if(event.channel.type == ChannelType.PRIVATE) {
            if (event.message.contentRaw == "!verify") {
                
            }
        } else {
            return
        }
    }
}

fun apiRequest() {
    val baseurl = "https://open-api.bahn.de"
    val path = "/bin/rest.exe/location.name?authKey=${Main.dotenv["DB_API_KEY"]}&"
    val lang = "de"
    val location = "&input="
    val city = "Frankfurt+hbf"
    val format = "&format=json"
    val url = baseurl+path+lang+location+city+format

    val response = URL(url).readText()

    println(response)
}
package space.bahnfreunde.verify

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.ChannelType
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import okhttp3.OkHttpClient
import okhttp3.Request
import space.bahnfreunde.Main

class Verification : ListenerAdapter() {
    private val verificationCodes: MutableMap<String, User> = HashMap()

    override fun onMessageReceived(event: MessageReceivedEvent) {
        if(event.channel.type == ChannelType.PRIVATE) {
            if (event.message.contentRaw == "!verify") {
                apiRequest()
                event.channel.sendMessage("Working").queue()
            }
        } else {
            return
        }
    }
}

fun apiRequest() {

    /**
     * get
     * https://apis.deutschebahn.com/db-api-marketplace/apis/timetables/v1/station/{pattern}
     * Beschreibung
     *
     * This public interface allows access to information about a station.
     * Sicherheit
     * ClientSecret
     * (Typ: Geheimer API-Schlüssel)
     * DB-Api-Key
     * apiKey befindet sich unter header
     * ClientId
     * (Typ: API-Schlüssel)
     * DB-Client-Id
     * apiKey befindet sich unter header
     */

    val baseurl = "https://apis.deutschebahn.com"
    val path = "/db-api-marketplace/apis/timetables/v1/"
    val station = ""

    val client = OkHttpClient()

    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).execute().use { response ->
        val responseBody = response.body!!.string()
        println(responseBody)
    }
}
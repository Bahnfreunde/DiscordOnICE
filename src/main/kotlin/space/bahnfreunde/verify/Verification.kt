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
                // do api request
                event.channel.sendMessage("Working").queue()
            }
        } else {
            return
        }
    }
}

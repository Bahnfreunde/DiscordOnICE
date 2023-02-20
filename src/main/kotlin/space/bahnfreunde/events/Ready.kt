package space.bahnfreunde.events

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import space.bahnfreunde.verify.Verification

class Ready : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        event.jda.addEventListener(Verification())
    }
}
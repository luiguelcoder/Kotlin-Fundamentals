package nearshorecode.com.eventsapp.view.adapter

import nearshorecode.com.eventsapp.model.Speaker

interface SpeakerListener {
    fun onSpeakerClicked(speaker: Speaker, position: Int) {

    }
}
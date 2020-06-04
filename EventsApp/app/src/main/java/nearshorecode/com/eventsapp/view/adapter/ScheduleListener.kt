package nearshorecode.com.eventsapp.view.adapter

import nearshorecode.com.eventsapp.model.Conference

interface ScheduleListener {
    fun onConferenceClicked(conference: Conference, position: Int) {

    }
}
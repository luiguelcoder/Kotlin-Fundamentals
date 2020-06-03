package nearshorecode.com.eventsapp.view.adapter

import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nearshorecode.com.eventsapp.R

class ScheduleAdapter() : RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {
    var listConference = ArrayList<Conference>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        )

    override fun getItemCount() = listConference.size

    override fun onBindViewHolder(holder: ScheduleAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvConferenceName = itemView.findViewById<TextView>(R.id.tvItemScheduleConferenceName)
        val tvConferenceSpeaker = itemView.findViewById<TextView>(R.id.tvItemScheduleNameSpeaker)
        val tvConferenceTag = itemView.findViewById<TextView>(R.id.tvItemScheduleTag)
        val tvConferenceHour = itemView.findViewById<TextView>(R.id.tvItemScheduleHour)
        val tvConferenceAmPm = itemView.findViewById<TextView>(R.id.tvItemScheduleTime)

    }
}
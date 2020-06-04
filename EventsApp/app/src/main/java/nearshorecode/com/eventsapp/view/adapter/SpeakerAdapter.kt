package nearshorecode.com.eventsapp.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import nearshorecode.com.eventsapp.R
import nearshorecode.com.eventsapp.model.Speaker
import kotlin.collections.ArrayList

class SpeakerAdapter(val speakerListener: SpeakerListener) :
    RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listspeaker = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_speaker, parent, false)
        )

    override fun getItemCount() = listspeaker.size

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {
        val speaker: Speaker = listspeaker.get(position)
        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerJob.text = speaker.jobTitle
        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivSpeakerImg)

        holder.itemView.setOnClickListener {
            speakerListener.onSpeakerClicked(speaker, position)
        }
    }

    fun updateData(data: List<Speaker>) {
        listspeaker.clear()
        listspeaker.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivSpeakerImg = itemView.findViewById<ImageView>(R.id.ivItemSpeakerImg)
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvItemSpeakerName)
        val tvSpeakerJob = itemView.findViewById<TextView>(R.id.tvItemSpeakerJob)
    }
}
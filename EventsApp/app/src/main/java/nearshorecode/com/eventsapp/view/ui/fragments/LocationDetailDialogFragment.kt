package nearshorecode.com.eventsapp.view.ui.fragments


import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_location_detail_dialog.*
import kotlinx.android.synthetic.main.fragment_schedule_detail.*

import nearshorecode.com.eventsapp.R
import nearshorecode.com.eventsapp.model.Location
import java.text.SimpleDateFormat

/**
 * A simple [Fragment] subclass.
 */
class LocationDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_location_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val location = Location()
        toolbarLocation.navigationIcon =
            ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        toolbarLocation.setTitleTextColor(Color.WHITE)
        toolbarLocation.setNavigationOnClickListener {
            dismiss()
        }

        tvLocationDetailName.text = location.name
        tvLocationDetailPlace.text = location.address
        tvLocationDetailPhone.text = location.phone
        tvLocationDetailLink.text = location.website

        llPhoneSection.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel: ${location.phone}")
            }

            startActivity(intent)
        }

        llwebSiteSection.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(location.website)
            }
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
    }
}

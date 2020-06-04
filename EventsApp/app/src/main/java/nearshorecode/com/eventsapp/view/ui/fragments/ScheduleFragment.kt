package nearshorecode.com.eventsapp.view.ui.fragments

import android.os.Bundle
import android.telecom.Conference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_schedule.*
import kotlinx.android.synthetic.main.fragment_speakers.*
import nearshorecode.com.eventsapp.R
import nearshorecode.com.eventsapp.view.adapter.ScheduleAdapter
import nearshorecode.com.eventsapp.view.adapter.ScheduleListener
import nearshorecode.com.eventsapp.viewmodel.ScheduleViewModel

class ScheduleFragment : Fragment(), ScheduleListener {
    private lateinit var scheduleAdapter: ScheduleAdapter
    private lateinit var viewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ScheduleViewModel::class.java)
        viewModel.refresh()

        scheduleAdapter = ScheduleAdapter(this)

        rvSchedule.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = scheduleAdapter
        }

        observerViewModel()
    }

    fun observerViewModel() {
        viewModel.listSchedule.observe(
            viewLifecycleOwner,
            Observer<List<Conference>> { schedule -> scheduleAdapter.updateData(schedule) })

        viewModel.isLoading.observe(
            viewLifecycleOwner, Observer<Boolean> {
                if (it != null) {
                    rlSpeakersBase.visibility = View.INVISIBLE
                }
            }
        )
    }

    override fun onConferenceClicked(
        conference: nearshorecode.com.eventsapp.model.Conference,
        position: Int
    ) {
        val bundle = bundleOf("conference" to conference)
        findNavController().navigate(R.id.scheduleDetailFragmentDialog, bundle)
    }
}

package nearshorecode.com.eventsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import nearshorecode.com.eventsapp.model.Conference
import nearshorecode.com.eventsapp.model.Speaker
import nearshorecode.com.eventsapp.network.Callback
import nearshorecode.com.eventsapp.network.FirestoreService
import java.lang.Exception

class SpeakerViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh() {
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {

            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }

}
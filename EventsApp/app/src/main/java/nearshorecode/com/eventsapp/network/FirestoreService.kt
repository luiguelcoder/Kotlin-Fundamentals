package nearshorecode.com.eventsapp.network

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import nearshorecode.com.eventsapp.model.Conference
import nearshorecode.com.eventsapp.model.Speaker

const val CONFERENCES_COLLECTION_NAME = "conferences"
const val SPEAKERS_COLLECTION_NAME = "speakers"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init {
        // se ejecutara apenas se cree esta clase
        firebaseFirestore.firestoreSettings = settings
    }

    fun getSpeakers(callback: Callback<List<Speaker>>) {
        firebaseFirestore.collection(SPEAKERS_COLLECTION_NAME)
            .orderBy("category")
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Speaker::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

    fun getSchedule(callback: Callback<List<Conference>>) {
        firebaseFirestore.collection(CONFERENCES_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list2 = result.toObjects(Conference::class.java)
                    callback.onSuccess(list2)
                    break
                }
            }

    }
}
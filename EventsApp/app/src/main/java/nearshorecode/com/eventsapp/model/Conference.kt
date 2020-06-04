package nearshorecode.com.eventsapp.model

import java.io.Serializable
import java.util.*

class Conference: Serializable{
    // Inicialización tardia utlizando lateinit
    lateinit var title: String
    lateinit var description: String
    lateinit var tag: String
    lateinit var dateTime: Date
    lateinit var speaker: String
}
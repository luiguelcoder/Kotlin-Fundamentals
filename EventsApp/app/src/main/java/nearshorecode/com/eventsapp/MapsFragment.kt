package nearshorecode.com.eventsapp

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.fragment.app.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import nearshorecode.com.eventsapp.model.Location

class MapsFragment : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        var location = Location()
        val zoom = 16f
        val centerMap = LatLng(location.latitud, location.longitud)
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap, zoom))

        val markerOptions = MarkerOptions().position(centerMap).title("Big Conference 2020")

        val bitmapDraw = context?.applicationContext?.let {
            ContextCompat.getDrawable(
                it,
                R.drawable.logo_platzi
            )
        } as BitmapDrawable

        val smallMarker = Bitmap.createScaledBitmap(bitmapDraw.bitmap, 150, 150, false)
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
        googleMap.addMarker(markerOptions)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}
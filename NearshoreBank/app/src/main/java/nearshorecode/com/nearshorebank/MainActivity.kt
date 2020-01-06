package nearshorecode.com.nearshorebank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var fabQrScanner: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(findViewById(R.id.my_toolbar))

        fabQrScanner = findViewById(R.id.home_fab_scan_qr_code)
        fabQrScanner!!.setOnClickListener{
            val intent = Intent(this@MainActivity, ScanActivity::class.java)
            startActivity(intent)
        }
    }

    /**override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater): Boolean {
        return super.onCreateOptionsMenu(menu)
        inflater?.inflate(R.menu.settings_menu)
    }*/
}

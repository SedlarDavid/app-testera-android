package cz.sedlardavid.testera.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPowerManagement = findViewById<Button>(R.id.btnPowerManagement)
        btnPowerManagement.setOnClickListener {
            val intent = Intent(this, PowerManagementActivity::class.java)

            startActivity(intent)
        }
    }
}
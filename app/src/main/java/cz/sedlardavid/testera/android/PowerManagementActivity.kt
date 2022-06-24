package cz.sedlardavid.testera.android

import android.content.Context
import android.os.Bundle
import android.os.PowerManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.concurrent.fixedRateTimer


class PowerManagementActivity : AppCompatActivity() {


    lateinit var timer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_power_management)

        val pm = getSystemService(Context.POWER_SERVICE) as PowerManager

        timer = fixedRateTimer("timer", false, 0, 1000) {
            this@PowerManagementActivity.runOnUiThread {
                val isInteractive = pm.isInteractive
                val screenStatus = if (isInteractive) "ACTIVE" else "INACTIVE"
                Toast.makeText(
                    this@PowerManagementActivity,
                    "Screen status $screenStatus",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onDestroy() {
        timer.cancel()
        super.onDestroy()
    }


}







package cz.sedlardavid.testera.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import cz.sedlardavid.testera.android.components.main.ButtonMain
import cz.sedlardavid.testera.android.components.main.Greeting
import cz.sedlardavid.testera.android.components.main.LayoutMain
import cz.sedlardavid.testera.android.components.main.MainButtonData

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LayoutMain(content = {
                Greeting()
                ButtonMain(
                    MainButtonData(
                        this@MainActivity,
                        PowerManagementActivity::class.java,
                        R.string.power_management,
                    )
                )
            })
        }

    }
}



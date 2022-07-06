package cz.sedlardavid.testera.android

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPowerManagement = findViewById<Button>(R.id.btnPowerManagement)
        btnPowerManagement.setOnClickListener {
            val intent = Intent(this, PowerManagementActivity::class.java)

            startActivity(intent)
        }

        val greeting = findViewById<ComposeView>(R.id.textView)
        greeting.setContent {
            MaterialTheme { // or AppCompatTheme
                Greeting()
            }
        }
    }
}

@Composable
private fun Greeting() {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 50.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
@Preview
private fun GreetingPreview() {
    Text(
        text = stringResource(R.string.app_name),
        style = MaterialTheme.typography.h5,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp, vertical = 50.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}
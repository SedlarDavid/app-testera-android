package cz.sedlardavid.testera.android.components.main

import android.content.Context
import android.content.Intent
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.core.content.ContextCompat


data class MainButtonData<T>(val intentContext: Context, val intentClass: Class<T>, val textId: Int)

@Composable
fun <T> ButtonMain(data: MainButtonData<T>) {
    Button(
        onClick = {
            val intent = Intent(data.intentContext, data.intentClass)

            ContextCompat.startActivity(data.intentContext, intent, null)
        },
    ) {
        Text(text = stringResource(id = data.textId))

    }
}
package cz.sedlardavid.testera.android.components.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.sedlardavid.testera.android.R


@Composable
fun Greeting() {
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
    Greeting()
}
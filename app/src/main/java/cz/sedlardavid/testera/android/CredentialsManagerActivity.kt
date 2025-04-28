package cz.sedlardavid.testera.android

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.credentials.CreatePasswordRequest
import androidx.credentials.exceptions.CreateCredentialException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CredentialsManagerActivity : ComponentActivity() {

    private lateinit var credentialManager: CredentialManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        credentialManager = CredentialManager.create(this)

        setContent {
            CredentialsManagerScreen(
                onSaveCredentials = { username, password, origin ->
                    saveCredential(username, password, origin)
                }
            )
        }
    }

    private fun saveCredential(username: String, password: String, origin: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val request = CreatePasswordRequest(id = username, password = password, origin = origin)
                credentialManager.createCredential(
                    request = request,
                    context = this@CredentialsManagerActivity
                )
                Toast.makeText(this@CredentialsManagerActivity, "Credential saved", Toast.LENGTH_SHORT).show()
            } catch (e: CreateCredentialException) {
                Toast.makeText(this@CredentialsManagerActivity, "Save failed: ${e.errorMessage}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

@Composable
fun CredentialsManagerScreen(
    onSaveCredentials: (String, String, String) -> Unit
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Save demo credentials for testing:")

        Button(onClick = {
            onSaveCredentials(
                "user1@mastodon.sedlardavid.cz",
                "PasswordUser1!",
                "mastodon.sedlardavid.cz"
            )
            onSaveCredentials(
                "user2@bluesky.sedlardavid.cz",
                "PasswordUser2!",
                "sedlardavid.cz"
            )
        }) {
            Text("Save Two Credentials")
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("Test Autofill Login Form:")

        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )
    }
}
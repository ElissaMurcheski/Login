package com.example.mylogin

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mylogin.components.ButtonFillMaxWidth
import com.example.mylogin.components.InputText
import com.example.mylogin.components.Label
import com.example.mylogin.ui.theme.MyLoginTheme

val usernameAdmin = "elissa"
val passwordAdmin = "admin"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyLoginTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    MyApp(this)
                }
            }
        }
    }
}

@Composable
fun MyApp(context: Context) {
    Column(modifier = Modifier.padding(10.dp)) {
        Content(context)
    }
}

@Composable
private fun Content(context: Context) {
    val usernameText = remember { mutableStateOf("") }
    val passwordText = remember { mutableStateOf("") }
    Row {
        Image(
            painter = painterResource(R.mipmap.ic_user_icon_foreground),
            contentDescription = "User Icon",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
        )
    }
    Row {
        Label(R.string.username)
    }
    Row {
        InputText(value = usernameText.value) { usernameText.value = it }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row {
        Label(R.string.password)
    }
    Row {
        InputText(value = passwordText.value) { passwordText.value = it }
    }
    Spacer(modifier = Modifier.height(20.dp))
    Row {
        ButtonFillMaxWidth(R.string.login) {
            if (usernameAdmin == usernameText.value && passwordAdmin == passwordText.value) {
                Toast.makeText(
                    context, "Logado com sucesso!", Toast.LENGTH_LONG
                ).show()
            } else {
                Toast.makeText(
                    context, "Usuário e/ou senha inválida", Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
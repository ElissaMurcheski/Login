package com.example.mylogin.ui.screns

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mylogin.R
import com.example.mylogin.components.ButtonFillMaxWidth
import com.example.mylogin.components.InputPassword
import com.example.mylogin.components.InputText
import com.example.mylogin.components.Label
import com.example.mylogin.viewmodels.UserViewModel

@Composable
fun SignUpScreen(context: Context, navController: NavHostController) {
    val userViewModel: UserViewModel = viewModel()
    val user = userViewModel.uiState.collectAsState()

    Column {
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
            Label(R.string.email)
        }
        Row {
            InputText(value = user.value.username) { userViewModel.updateUsername(it) }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Label(R.string.username)
        }
        Row {
            InputText(value = user.value.password) { userViewModel.updatePassword(it) }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Label(R.string.password)
        }
        Row {
            InputPassword(value = user.value.email) { userViewModel.updateEmail(it) }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            ButtonFillMaxWidth(R.string.signUp, { navController.navigate("signIn") })
        }
    }
}
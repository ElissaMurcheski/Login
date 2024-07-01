package com.example.mylogin.ui.screns

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.mylogin.R
import com.example.mylogin.components.ButtonFillMaxWidth
import com.example.mylogin.components.ButtonFillMaxWidthElevated
import com.example.mylogin.components.InputPassword
import com.example.mylogin.components.InputText
import com.example.mylogin.components.Label
import com.example.mylogin.database.AppDatabase
import com.example.mylogin.viewmodels.UserViewModel
import com.example.mylogin.viewmodels.UserViewModelFactory

@Composable
fun SignInScreen(navController: NavHostController) {
    val context = LocalContext.current
    val db = AppDatabase.getDatabase(context)
    val userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(db)
    )
    val user = userViewModel.uiState.collectAsState()

    Column(Modifier.padding(10.dp)) {
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
            InputText(value = user.value.username, { userViewModel.updateUsername(it) })
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Label(R.string.password)
        }
        Row {
            InputPassword(value = user.value.password) { userViewModel.updatePassword(it) }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row {
            ButtonFillMaxWidth(R.string.signIn, {
                navController.navigate("main")
            })
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            ButtonFillMaxWidthElevated(R.string.signUp) {
                navController.navigate("signUp")
            }
        }
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen(rememberNavController())
}
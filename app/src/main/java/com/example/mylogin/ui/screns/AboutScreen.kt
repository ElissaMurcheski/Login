package com.example.mylogin.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun AboutScreen(navController: NavHostController) {
    Column {
        Row {
            Text("Nome: Elissa Murcheski")
        }
        Row {
            Text("Projeto: MyLogin")
        }
    }
}
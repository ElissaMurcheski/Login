package com.example.mylogin.ui.screns

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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

@Preview
@Composable
fun AboutScreenPreview() {
    AboutScreen(rememberNavController())
}
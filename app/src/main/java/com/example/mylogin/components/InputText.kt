package com.example.mylogin.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun RowScope.InputText(value: String, onValueChange: (String) -> Unit) {
    TextField(value, onValueChange, modifier = Modifier.fillMaxWidth())
}
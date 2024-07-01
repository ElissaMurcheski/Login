package com.example.mylogin.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable

@Composable
fun RowScope.InputNumber(value: String, onValueChange: (String) -> Unit) {
    InputText(
        value,
        onValueChange,
    )
}
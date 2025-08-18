package com.example.appAsamblea.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun OTPInput(code: String, onCodeChange: (String) -> Unit) {
    Row {
        repeat(6) { index ->
            OutlinedTextField(
                value = code.getOrNull(index)?.toString() ?: "",
                onValueChange = { value ->
                    if (value.length <= 1) {
                        val newCode = code.toCharArray().toMutableList()
                        if (index < code.length) newCode[index] = value.firstOrNull() ?: ' ' else newCode.add(value.firstOrNull() ?: ' ')
                        onCodeChange(newCode.joinToString("").trim())
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = androidx.compose.ui.Modifier.weight(1f)
            )
        }
    }
}

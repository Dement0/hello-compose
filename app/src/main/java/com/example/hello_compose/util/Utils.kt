package com.example.hello_compose.util

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarData
import androidx.compose.material.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
private fun showSnackbar() {
    Snackbar(
        modifier = Modifier.padding(16.dp),
        snackbarData = object : SnackbarData {
            override val actionLabel: String?
                get() = "Action label"
            override val duration: SnackbarDuration
                get() = SnackbarDuration.Short
            override val message: String
                get() = "This is a snackbar!"
            override fun dismiss() {
                println("Dismissed")
            }
            override fun performAction() {
                println("Performed action")
            }
        }
    )
}

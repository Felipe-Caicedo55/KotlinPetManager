
package com.example.kotlinpetmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.kotlinpetmanager.ui.PantallaPrincipal
import com.example.kotlinpetmanager.ui.theme.KotlinPetManagerTheme
import com.example.kotlinpetmanager.viewmodel.PacienteViewModel

class MainActivity : ComponentActivity() {

    private val pacienteViewModel: PacienteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KotlinPetManagerTheme {
                PantallaPrincipal(
                    viewModel = pacienteViewModel
                )
            }
        }
    }
}

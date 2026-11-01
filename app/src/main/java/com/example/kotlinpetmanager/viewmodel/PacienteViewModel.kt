package com.example.kotlinpetmanager.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.kotlinpetmanager.model.Paciente

class PacienteViewModel : ViewModel() {

    // Lista observable de pacientes
    var pacientes by mutableStateOf(listOf<Paciente>())
        private set

    // Estado del formulario
    var nombre by mutableStateOf("")
        private set

    var especie by mutableStateOf("")
        private set

    var edad by mutableStateOf("")
        private set

    var contactoEmergencia by mutableStateOf("")
        private set

    var esUrgencia by mutableStateOf(false)
        private set

    // Actualizar campos del formulario
    fun actualizarNombre(valor: String) {
        nombre = valor
    }

    fun actualizarEspecie(valor: String) {
        especie = valor
    }

    fun actualizarEdad(valor: String) {
        edad = valor
    }

    fun actualizarContacto(valor: String) {
        contactoEmergencia = valor
    }

    fun actualizarUrgencia(valor: Boolean) {
        esUrgencia = valor
    }

    // Registrar un nuevo paciente
    fun agregarPaciente(): Boolean {

        val edadNumero = edad.toIntOrNull()

        if (nombre.isBlank() ||
            especie.isBlank() ||
            contactoEmergencia.isBlank() ||
            edadNumero == null ||
            edadNumero < 0) {
            return false
        }

        val nuevoPaciente = Paciente(
            id = (pacientes.maxOfOrNull { it.id } ?: 0) + 1,
            nombre = nombre.trim(),
            especie = especie.trim(),
            edad = edadNumero,
            contactoEmergencia = contactoEmergencia.trim(),
            esUrgencia = esUrgencia
        )

        pacientes = pacientes + nuevoPaciente

        limpiarFormulario()

        return true
    }

    // Limpiar los campos del formulario
    fun limpiarFormulario() {
        nombre = ""
        especie = ""
        edad = ""
        contactoEmergencia = ""
        esUrgencia = false
    }
}
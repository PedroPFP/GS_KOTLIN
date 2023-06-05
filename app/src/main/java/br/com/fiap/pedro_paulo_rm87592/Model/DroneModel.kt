package br.com.fiap.pedro_paulo_rm87592.Model

import android.text.Editable
import java.util.UUID

data class DroneModel (
    val idDrone: UUID,
    val nomeDrone: String,
    val idUser: UUID,
)


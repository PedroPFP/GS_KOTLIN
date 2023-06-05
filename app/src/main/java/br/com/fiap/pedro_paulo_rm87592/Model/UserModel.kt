package br.com.fiap.pedro_paulo_rm87592.Model

import android.os.Parcelable
import android.text.Editable
import br.com.fiap.pedro_paulo_rm87592.UuidSerializable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.util.UUID

@kotlinx.serialization.Serializable
data class UserModel(
    @kotlinx.serialization.Serializable(with = UuidSerializable::class)
    val id: UUID,
    val email: String,
    val login: String,
    val password: String,
)

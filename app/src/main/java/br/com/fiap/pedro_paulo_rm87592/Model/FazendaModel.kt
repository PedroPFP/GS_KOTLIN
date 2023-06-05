package br.com.fiap.pedro_paulo_rm87592.Model

import br.com.fiap.pedro_paulo_rm87592.Enuns.IrrigacaoEnum
import br.com.fiap.pedro_paulo_rm87592.Enuns.NutrientesEnum
import java.util.UUID

data class FazendaModel (
    val idFazenda: UUID,
    val nomeFazenda: String,
    val idUser: UUID,
    val culturaPlantacao: String,
    val pragasDoencas: String,
    val nutrientesNoSolo: NutrientesEnum,
    val irrigacao: IrrigacaoEnum,
    )
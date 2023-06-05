package br.com.fiap.pedro_paulo_rm87592.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.pedro_paulo_rm87592.Model.FazendaModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.ViewFazendaItemBinding

class FazendaAdapter: RecyclerView.Adapter<FazendaAdapter.CharacterItemViewHolder>() {

    private var fazendaList: MutableList<FazendaModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ViewFazendaItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_fazenda_item,
                parent,
                false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(fazendaList[position], position)
    }

    override fun getItemCount(): Int {
        return fazendaList.size
    }

    fun setData(list: List<FazendaModel>) {
        with(fazendaList) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CharacterItemViewHolder(
        private val view: ViewFazendaItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(fazendaInfo: FazendaModel, itemPosition: Int) {
            view.textNomeFazenda.text = "Nome: "+fazendaInfo.nomeFazenda
            view.textPragasFazenda.text ="Pragas: "+fazendaInfo.pragasDoencas
            view.textCulturaFazenda.text = "Cultura: "+fazendaInfo.culturaPlantacao
            view.textIrrigacaoFazenda.text = "Irrigação: "+fazendaInfo.irrigacao.toString()
            view.textNutrientesFazenda.text = "Nutrientes: "+fazendaInfo.nutrientesNoSolo.toString()
        }
    }
}
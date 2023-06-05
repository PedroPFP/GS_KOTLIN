package br.com.fiap.pedro_paulo_rm87592.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.pedro_paulo_rm87592.Model.DroneModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.ViewDroneItemBinding

class DroneAdapter : RecyclerView.Adapter<DroneAdapter.CharacterItemViewHolder>() {

    private var droneList: MutableList<DroneModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val binding = ViewDroneItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(
                R.layout.view_drone_item,
                parent,
                false
            )
        )
        return CharacterItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        holder.bindView(droneList[position], position)
    }

    override fun getItemCount(): Int {
        return droneList.size
    }

    fun setData(list: List<DroneModel>) {
        with(droneList) {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    inner class CharacterItemViewHolder(
        private val view: ViewDroneItemBinding
    ) : RecyclerView.ViewHolder(view.root) {

        fun bindView(droneInfo: DroneModel, itemPosition: Int) {
            view.droneNomeValue.text = "Nome: "+droneInfo.nomeDrone
        }
    }
}
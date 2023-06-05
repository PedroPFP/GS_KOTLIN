package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.DataSources.FazendasDataSource
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.Enuns.IrrigacaoEnum
import br.com.fiap.pedro_paulo_rm87592.Enuns.NutrientesEnum
import br.com.fiap.pedro_paulo_rm87592.Model.FazendaModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentFazendaCadastroBinding
import java.util.UUID

class FazendaCadastroFragment : Fragment(){

    lateinit var binding: FragmentFazendaCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFazendaCadastroBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.spinnerIrrigacaoItens.adapter = context?.let { ArrayAdapter<IrrigacaoEnum>(it,R.layout.spinner_nexus_item,IrrigacaoEnum.values()) }
        binding.spinnerNutrientesItens.adapter = context?.let { ArrayAdapter<NutrientesEnum>(it,R.layout.spinner_nexus_item,NutrientesEnum.values()) }
        cadastro()
    }

    private fun cadastro() {
        binding.cadastroButton.setOnClickListener {
            val uuid = UUID.randomUUID()
            val nome = binding.textInputEditNome.text.toString()
            val userId = LoggedUser.user?.id
            val cultura = binding.textInputEditCultura.text.toString()
            val pragas = binding.textInputEditPragas.text.toString()
            val irrigacao = binding.spinnerIrrigacaoItens.selectedItem
            val nutrientes  = binding.spinnerNutrientesItens.selectedItem
            FazendasDataSource.fazendaList.add(FazendaModel(uuid,nome,userId!!,cultura,pragas,nutrientes as NutrientesEnum,irrigacao as IrrigacaoEnum))
            findNavController().navigate(
                R.id.action_fazendaCadastroItem_to_fazendaItem
            )

        }
    }

}
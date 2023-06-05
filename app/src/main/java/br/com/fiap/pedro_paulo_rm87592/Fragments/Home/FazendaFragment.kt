package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.Adapters.FazendaAdapter
import br.com.fiap.pedro_paulo_rm87592.DataSources.FazendasDataSource
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentFazendaBinding

class FazendaFragment: Fragment(){
    lateinit var binding: FragmentFazendaBinding

    val fazendaAdapter = FazendaAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFazendaBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
    }

    private fun setupViews() {
        binding.btnAdicionarFazenda.setOnClickListener {
            findNavController().navigate(
                R.id.action_fazendaItem_to_fazendaCadastroItem
            )
        }

        binding.recyclerViewFazendas.setHasFixedSize(true)
        binding.recyclerViewFazendas.adapter = fazendaAdapter

        fazendaAdapter.setData(FazendasDataSource.fazendaList.filter {
            it.idUser == LoggedUser.user?.id
        })

    }
}
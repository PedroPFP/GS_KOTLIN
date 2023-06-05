package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.Adapters.DroneAdapter
import br.com.fiap.pedro_paulo_rm87592.DataSources.DronesDataSource
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentDroneBinding

class DroneFragment : Fragment(){

    lateinit var binding: FragmentDroneBinding

    val droneAdapter = DroneAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDroneBinding.inflate(
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
        binding.btnAdicionarDrone.setOnClickListener {
            findNavController().navigate(
                R.id.action_droneItem_to_droneCadastroItem
            )
        }

        binding.recyclerViewDrones.setHasFixedSize(true)
        binding.recyclerViewDrones.adapter = droneAdapter

        droneAdapter.setData(DronesDataSource.dronesList.filter {
            it.idUser == LoggedUser.user?.id
        })

    }

}
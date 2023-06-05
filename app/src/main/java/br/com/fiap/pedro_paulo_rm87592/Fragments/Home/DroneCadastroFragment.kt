package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.DataSources.DronesDataSource
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.Model.DroneModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentDroneCadastroBinding
import java.util.UUID

class DroneCadastroFragment: Fragment(){

    lateinit var binding: FragmentDroneCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDroneCadastroBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cadastrar()

    }

    private fun cadastrar() {
        binding.btnCadastrarDrone.setOnClickListener {
            val nome = binding.textInputEditDrone.text.toString()
            val uuid = UUID.randomUUID()
            val user = LoggedUser.user?.id

            DronesDataSource.dronesList.add(DroneModel(uuid,nome,user!!))

            findNavController().navigate(
                R.id.action_droneCadastroItem_to_droneItem
            )

        }
    }

}
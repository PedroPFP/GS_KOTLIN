package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.Model.UserModel
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentCadastroBinding
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentHomeBinding
import kotlinx.serialization.json.Json

class HomeFragment : Fragment(){

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }



}
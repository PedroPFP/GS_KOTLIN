package br.com.fiap.pedro_paulo_rm87592.Fragments.Home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.HomeActivity
import br.com.fiap.pedro_paulo_rm87592.MainActivity
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentProfileBinding

class ProfileFragment: Fragment() {

    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textNome.text = "Nome - ${LoggedUser.user?.login}".toString()
        binding.textEmail.text = "Email - ${LoggedUser.user?.email}".toString()
        setupViews()
    }

    private fun setupViews() {
        binding.btnDeslogar.setOnClickListener {
            val intent = Intent(getActivity(), MainActivity::class.java)
            LoggedUser.user = null
            startActivity(intent)
        }
    }



}
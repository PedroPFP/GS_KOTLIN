package br.com.fiap.pedro_paulo_rm87592.Fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.DataSources.LoggedUser
import br.com.fiap.pedro_paulo_rm87592.DataSources.UsersDataSource
import br.com.fiap.pedro_paulo_rm87592.HomeActivity
import br.com.fiap.pedro_paulo_rm87592.Model.UserModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentLoginBinding
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

class LoginFragment: Fragment() {

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(
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

    private fun enableButton() {
        if(!binding.textInputEditEmail.text.toString().isEmpty() && !binding.textInputEditPassword.text.toString().isEmpty() ) {
            binding.loginButton.isEnabled=true
            binding.loginButton.isClickable=true
            binding.loginButton?.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.nexus))
        }
        else {
            disableButton()
        }
    }

    private fun disableButton() {
        binding.loginButton?.setBackgroundColor(ContextCompat.getColor(requireContext(), androidx.appcompat.R.color.material_grey_300))
        binding.loginButton.isEnabled=false
        binding.loginButton.isClickable=false
    }

    private fun setupViews() {
        disableButton()
        binding.cadastroButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_loginFragment_to_cadastroFragment
            )
        }
        binding.textInputEditEmail.addTextChangedListener {
            enableButton()
        }
        binding.textInputEditPassword.addTextChangedListener {
            enableButton()
        }
        binding.loginButton.setOnClickListener {
            val email = binding.textInputEditEmail.text
            val password = binding.textInputEditPassword.text
            var user: UserModel? =null;
            var logado = false;
            UsersDataSource.usersList.forEach {
            if(it.email == email.toString())
                if(it.password == password.toString()){
                    Toast.makeText(context,"Logado com sucesso!", Toast.LENGTH_SHORT).show()
                    logado = true
                    user = it

                }

            }
            if(logado){
                val intent = Intent(getActivity(), HomeActivity::class.java)
                LoggedUser.user = user!!;
                startActivity(intent)
            }
            else {
                Toast.makeText(context,"Falha no login!",Toast.LENGTH_SHORT).show()
            }
        }
    }

}
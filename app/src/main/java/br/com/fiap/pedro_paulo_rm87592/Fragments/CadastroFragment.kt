package br.com.fiap.pedro_paulo_rm87592.Fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.pedro_paulo_rm87592.DataSources.UsersDataSource
import br.com.fiap.pedro_paulo_rm87592.Model.UserModel
import br.com.fiap.pedro_paulo_rm87592.R
import br.com.fiap.pedro_paulo_rm87592.databinding.FragmentCadastroBinding
import java.util.UUID


class CadastroFragment : Fragment(){

    lateinit var binding: FragmentCadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(
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

    private fun cadastrar(){
        binding.cadastroButton.setOnClickListener {
            val login = binding.textInputEditLogin.text.toString()
            val password = binding.textInputEditPassword.text.toString()
            val email = binding.textInputEditEmail.text.toString()

            UsersDataSource.usersList.add(UserModel(id = UUID.randomUUID(), email = email,login = login, password = password))
            Toast.makeText(context,"Cadastrado com sucesso!",Toast.LENGTH_SHORT).show()

            findNavController().navigate(
                R.id.action_cadastroFragment_to_loginFragment
            )
        }
    }

}
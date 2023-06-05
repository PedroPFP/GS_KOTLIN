package br.com.fiap.pedro_paulo_rm87592

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import br.com.fiap.pedro_paulo_rm87592.Fragments.Home.HomeFragment
import br.com.fiap.pedro_paulo_rm87592.Model.UserModel
import br.com.fiap.pedro_paulo_rm87592.databinding.ActivityHomeBinding
import br.com.fiap.pedro_paulo_rm87592.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import java.io.Serializable

class HomeActivity: AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    val navController by lazy { findNavController(R.id.nav_host_fragment_container_home)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bottomNavigation()
        supportActionBar?.hide()
    }



    private fun bottomNavigation() {

        val navigationItemSelected = NavigationBarView.OnItemSelectedListener {item ->
            when (item.itemId) {
                R.id.homeItem -> {
                    navController.navigate(R.id.homeItem)
                    return@OnItemSelectedListener true
                }
                R.id.droneItem -> {
                    navController.navigate(R.id.droneItem)
                    return@OnItemSelectedListener true
                }
                R.id.fazendaItem -> {
                    navController.navigate(R.id.fazendaItem)
                    return@OnItemSelectedListener true
                }
                R.id.perfilItem -> {
                    navController.navigate(R.id.perfilItem)
                    return@OnItemSelectedListener true
                }
                else -> {
                }
            }
            false
        }
        binding.bottomNavigationView.setOnItemSelectedListener(navigationItemSelected)
    }



}
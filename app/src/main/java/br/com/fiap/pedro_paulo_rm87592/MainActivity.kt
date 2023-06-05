package br.com.fiap.pedro_paulo_rm87592

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.fiap.pedro_paulo_rm87592.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}
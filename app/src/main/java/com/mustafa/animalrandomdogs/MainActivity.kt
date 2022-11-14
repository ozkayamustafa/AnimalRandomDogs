package com.mustafa.animalrandomdogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.mustafa.animalrandomdogs.databinding.ActivityMainBinding
import com.mustafa.animalrandomdogs.fragment.DogsFragment
import com.mustafa.animalrandomdogs.viewmodel.DogsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = supportFragmentManager
        val fragment = DogsFragment()
        manager.beginTransaction().add(R.id.fragmentContainer,fragment).commit()


    }
}
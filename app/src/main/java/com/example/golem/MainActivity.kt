package com.example.golem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.golem.databinding.ActivityMainBinding
import com.example.golem.fragments.CharactersFragment
import com.example.golem.fragments.EpisodesFragment
import com.example.golem.fragments.LocationsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val charactersFragment = CharactersFragment()
        val locationsFragment = LocationsFragment()
        val episodesFragment = EpisodesFragment()

        switchFragment(charactersFragment)

        binding.bottomNavMenu.setOnItemSelectedListener{
            when (it.itemId){
                R.id.ic_characters -> switchFragment(charactersFragment)
                R.id.ic_locations -> switchFragment(locationsFragment)
                R.id.ic_episodes -> switchFragment(episodesFragment)
            }
            true
        }
    }

    private fun switchFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.main_scr_frame, fragment)
            commit()
        }
    }

}
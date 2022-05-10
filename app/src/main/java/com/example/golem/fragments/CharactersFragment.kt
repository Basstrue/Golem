package com.example.golem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.golem.CharacterData
import com.example.golem.CharacterListAdapter
import com.example.golem.MainActivity
import com.example.golem.R
import com.example.golem.databinding.FragmentCharactersBinding

class CharactersFragment: Fragment(R.layout.fragment_characters) {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val recycler = binding.characterListRecycler
        recycler.adapter = CharacterListAdapter(context, List<CharacterData>())
        return binding.root
    }
}
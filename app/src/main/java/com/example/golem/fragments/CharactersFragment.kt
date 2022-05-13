package com.example.golem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.golem.CharacterData
import com.example.golem.CharacterListAdapter
import com.example.golem.databinding.FragmentCharactersBinding
import com.example.golem.viewmodel.CharactersViewModel
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment: Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var charactersViewModel: CharactersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val root: View = binding.root
        initCharactersApi()
        return binding.root
    }

    private fun initAdapter(data: List<CharacterData>){
        character_list_recycler.layoutManager = LinearLayoutManager(requireContext())
        val adapter = CharacterListAdapter(data)
        character_list_recycler.adapter = adapter
    }

    fun initCharactersApi(){
        charactersViewModel = ViewModelProvider(this).get(CharactersViewModel::class.java)
        charactersViewModel.getApiData()
        charactersViewModel.charactersDataList.observe(requireActivity(), Observer { initAdapter(it)})
    }
}
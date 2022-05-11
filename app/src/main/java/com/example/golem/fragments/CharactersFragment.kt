package com.example.golem.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.golem.CharacterData
import com.example.golem.CharacterListAdapter
import com.example.golem.MainActivity
import com.example.golem.R
import com.example.golem.databinding.FragmentCharactersBinding

class CharactersFragment: Fragment() {

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val recycler: RecyclerView = root.findViewById(R.id.character_list_recycler)
        //val recycler: RecyclerView = view.findViewById(R.id.character_list_recycler)
        val characterlist = generateCharacters(100)
        recycler.adapter = CharacterListAdapter(requireContext(), characterlist)
        recycler.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    private fun generateCharacters(count: Int): List<CharacterData> {
       val charList = ArrayList<CharacterData>()
       for (i in 0 until count){
       val item = CharacterData("name$i", "status$i","species$i",  "gender$i" )
       charList += item
       }
       return charList
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
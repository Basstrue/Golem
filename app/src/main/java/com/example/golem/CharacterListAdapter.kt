package com.example.golem

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response


class CharacterListAdapter(private var characters: List<CharacterData>): RecyclerView.Adapter<CharacterListAdapter.VH>() {

    inner class VH(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.character_name)
        val species: TextView = view.findViewById(R.id.character_species)
        val status: TextView = view.findViewById(R.id.character_status)
        val gender: TextView = view.findViewById(R.id.character_gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.character_list_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
       holder.name.text = characters[position].name
       holder.status.text = characters[position].status
       holder.species.text = characters[position].species
       holder.gender.text = characters[position].gender
    }

    override fun getItemCount(): Int {
       return characters.size
    }

}
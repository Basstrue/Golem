package com.example.golem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.character_list_recycler)
        val characterlist = generate_characters(100)

        recycler.adapter = CharacterListAdapter(this, characterlist)
    }

    private fun generate_characters(count: Int): List<CharacterData> {
        val charList = ArrayList<CharacterData>()
        for (i in 0 until count){
        val item = CharacterData("name$i", "species$i", "status$i", "gender$i" )
        charList += item
        }
        return charList
    }
}
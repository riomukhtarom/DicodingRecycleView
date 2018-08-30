package com.example.casper.dicodingrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val items : MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = findViewById<RecyclerView>(R.id.rv_clublist)
        initData()

        list.layoutManager = LinearLayoutManager(this)
        list.adapter = RecycleViewAdapter(this, items)
    }

    private fun initData(){
        val name = resources.getStringArray(R.array.club_name)
        val image = resources.obtainTypedArray(R.array.club_logo)
        items.clear()

        for (i in name.indices){
            items.add(Item(name[i], image.getResourceId(i,0)))
        }

        image.recycle()
    }
}

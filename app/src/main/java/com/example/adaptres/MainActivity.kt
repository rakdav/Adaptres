package com.example.adaptres

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
   // private val countries:Array<String> = arrayOf("Бразилия","Аргентина","Колумбия","Чили","Уругвай")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView:ListView=findViewById(R.id.countriesList)
        val country:TextView=findViewById(R.id.select_country)
        val countries:Array<String> = resources.getStringArray(R.array.countries)
        val adapt:ArrayAdapter<String> =
            ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,countries)
        listView.adapter=adapt
        listView.setOnItemClickListener(AdapterView.OnItemClickListener { adapterView, view, i, l ->
//            val selectedItem:String=countries[i]
//            country.text=selectedItem
            val selected:SparseBooleanArray=listView.checkedItemPositions
            var res:String=""
            var i:Int=0
            while( i in countries.indices)
            {
                if(selected.get(i)) res+=countries[i]+","
                i++
            }
            country.text=res
        })
    }
}
package com.clauceta.mydrinks.Main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.clauceta.mydrinks.Entidades.Drinks
import com.clauceta.mydrinks.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var drink1 = Drinks("sex on the beach", "azul")
    var drink2 = Drinks("caipirinha", "so o alcool etilico")

    var lista_de_drinks: MutableList<Drinks> = mutableListOf(drink1, drink2)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }


    override fun onResume() {
        super.onResume()
        ExibeLista()
    }

    fun ExibeLista(){


        var adapter = MainAdapter(this, lista_de_drinks)

        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        main_recyclerview.adapter = adapter
        main_recyclerview.layoutManager = layoutManager
        main_recyclerview.addItemDecoration(dividerItemDecoration)


    }
}

package com.clauceta.mydrinks.main

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.clauceta.mydrinks.entidades.Drinks
import com.clauceta.mydrinks.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Contract.View {

    /*var drink1 = Drinks("sex on the beach", "azul")
    var drink2 = Drinks("caipirinha", "so o alcool etilico")*/

   // var lista_de_drinks: MutableList<Drinks> = mutableListOf()

    val presenter: Contract.Presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.onLoadList(0)

        btn_drinks_alcolicos.setOnClickListener {
            presenter.onLoadList(0)
        }

        btn_drinks_aleatorios.setOnClickListener {

                presenter.onLoadList(1)
        }

    }


    override fun onResume() {
        super.onResume()

    }

    override fun exibeLista(listaDeDrinks: List<Drinks>){


        var adapter = MainAdapter(this, listaDeDrinks)

        val layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        main_recyclerview.adapter = adapter
        main_recyclerview.layoutManager = layoutManager
        main_recyclerview.addItemDecoration(dividerItemDecoration)


        adapter.listenerClique { indexNotinhaClicada ->
            //val editanotinha = Intent(this, CadastraNotinhasActivity::class.java)
            /*editanotinha.putExtra(CadastraNotinhasActivity.REQUEST_NOTINHA, lista_de_itens.get(indexNotinhaClicada)) //manda um tipo notinha para a prox intent (Activity)
            startActivity(editanotinha)*/
        }


    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

}

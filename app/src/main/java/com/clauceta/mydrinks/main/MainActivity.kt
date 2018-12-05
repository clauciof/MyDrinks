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

class MainActivity : AppCompatActivity(), Contract.View, MainListFragment.onFragmentInteractionListener {

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

        val fragmentNewList = MainListFragment.newInstance(listaDeDrinks as ArrayList<Drinks> )

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, fragmentNewList)
                .addToBackStack(null)
                .commit()



    }

    override fun showMessage(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show()
    }

    override fun onFragmentInteraction(drink: Drinks) {

        val fragmentDetalhe = DetalhesFragment.newInstance(drink)

        supportFragmentManager.beginTransaction()
                .replace(R.id.fmMaster, fragmentDetalhe)
                .commit()
    }

}

package com.clauceta.mydrinks.main

import android.content.Context
import com.clauceta.mydrinks.entidades.Drinks

interface Contract {

    interface View{
         fun exibeLista(listaDeDrinks: List<Drinks>)
         fun showMessage(s: String)


    }

    interface Presenter{
        fun onLoadList(opcao: Int)
    }

}
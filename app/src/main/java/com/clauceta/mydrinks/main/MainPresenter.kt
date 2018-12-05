package com.clauceta.mydrinks.main

import android.content.Context
import android.widget.Toast
import com.clauceta.mydrinks.entidades.ListaDeDrinks
import com.clauceta.mydrinks.servicos.NovoServico
import com.clauceta.mydrinks.servicos.RetrofitInicializer
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainPresenter(val view: Contract.View): Contract.Presenter{

       override fun onLoadList(opcao: Int){/* Faz a integracao com a api e recebe a lista*/


           if(opcao==0){
               val novoServico = RetrofitInicializer().createNovoServico()

               val call = novoServico.getAlcoholicDrinks()

               call.enqueue(object: retrofit2.Callback<ListaDeDrinks>{
                   override fun onResponse(call: Call<ListaDeDrinks>, response: Response<ListaDeDrinks>) {
                       if(response.body() != null){
                           view.exibeLista(response.body()!!.drinks)
                       }else{
                           view.showMessage("Sem drinks para mostrar")
                       }
                   }

                   override fun onFailure(call: Call<ListaDeDrinks>, t: Throwable) {
                       view.showMessage("Falha na conexao")
                   }
               })
           }else{

               val novoServico = RetrofitInicializer().createNovoServico()

               val call = novoServico.getRandomDrinks()

               call.enqueue(object: retrofit2.Callback<ListaDeDrinks>{
                   override fun onResponse(call: Call<ListaDeDrinks>, response: Response<ListaDeDrinks>) {
                       if(response.body() != null){
                           view.exibeLista(response.body()!!.drinks)
                       }else{
                           view.showMessage("Sem drinks para mostrar")
                       }
                   }

                   override fun onFailure(call: Call<ListaDeDrinks>, t: Throwable) {
                       view.showMessage("Falha na conexao")
                   }
               })
           }


        }


}
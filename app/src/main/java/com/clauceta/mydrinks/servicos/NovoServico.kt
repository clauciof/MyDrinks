package com.clauceta.mydrinks.servicos

import com.clauceta.mydrinks.entidades.Drinks
import com.clauceta.mydrinks.entidades.ListaDeDrinks
import retrofit2.Call
import retrofit2.http.GET

interface NovoServico {

    /*companion object {
        private const val API_KEY = "1 "
    }*/

    //var drinkRandomico: Call<ListaDeDrinks>
    //var drinkAux: Call<ListaDeDrinks>

    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks(): Call<ListaDeDrinks>

    @GET("lookup.php")
    fun getDrinkDetails()

    @GET("random.php")
    fun getRandomDrinks(): Call<ListaDeDrinks>


   /* fun getListOfRandomDrinks(): Call<ListaDeDrinks> {

        for(i in 1..20) {
             drinkRandomico = getRandomDrinks()
        }
        return drinkRandomico
    }*/

}
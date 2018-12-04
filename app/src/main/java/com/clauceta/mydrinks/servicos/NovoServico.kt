package com.clauceta.mydrinks.servicos

import com.clauceta.mydrinks.entidades.ListaDeDrinks
import retrofit2.Call
import retrofit2.http.GET

interface NovoServico {

    /*companion object {
        private const val API_KEY = "1 "
    }*/


    @GET("filter.php?a=Alcoholic")
    fun getAlcoholicDrinks(): Call<ListaDeDrinks>

    @GET("lookup.php")
    fun getDrinkDetails()

    @GET("random.php")
    fun getRandomDrinks()

}
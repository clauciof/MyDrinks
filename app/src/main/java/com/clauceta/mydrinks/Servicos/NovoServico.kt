package com.clauceta.mydrinks.Servicos

import retrofit2.http.GET

interface NovoServico {

    /*companion object {
        private const val API_KEY = "1 "
    }*/


    @GET("1/filter.php?a=Alcoholic")
    fun getAlcoholicDrinks()

    @GET("1/lookup.php?i=13060")
    fun getDrinkDetails()

    @GET("1/random.php")
    fun getRandomDrinks()

}
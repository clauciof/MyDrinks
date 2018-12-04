package com.clauceta.mydrinks.Servicos

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInicializer {

    val retrofit = Retrofit.Builder().baseUrl("https://www.thecocktaildb.com/api/json/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()


    fun crateNovoServico() = retrofit.create(NovoServico::class.java)

}
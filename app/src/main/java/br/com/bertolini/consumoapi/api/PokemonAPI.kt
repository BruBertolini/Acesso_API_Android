package br.com.bertolini.consumoapi.api

import br.com.bertolini.consumoapi.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Retrofit



interface PokemonAPI{
    @GET("/api/v2/pokemon/{number}")
    fun search(@Path("number") number : String): Call<Pokemon>




}
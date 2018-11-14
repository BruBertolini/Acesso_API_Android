package br.com.bertolini.consumoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.bertolini.consumoapi.api.PokemonAPI
import br.com.bertolini.consumoapi.model.Pokemon
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btnSearch.setOnClickListener{
            seach()
        }
    }

    private fun seach(){
        var retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val pokeAPI = retrofit.create(PokemonAPI::class.java)

        pokeAPI.search( inputPokeNumber.text.toString())
                .enqueue(object : Callback<Pokemon> {
                    override fun onFailure(call: Call<Pokemon>?, t: Throwable?) {
                        Toast.makeText(
                                this@SearchActivity, t?.message, Toast.LENGTH_LONG
                        ).show()
                    }

                    override fun onResponse(call: Call<Pokemon>?, response: Response<Pokemon>?) {
                        if(response!!.isSuccessful){
                            val poke = response.body()
                            tvPokemon.text = poke?.name
                        }else{
                            Toast.makeText(
                                    this@SearchActivity, "Xii.. algo de errado não está certo", Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                })
    }
}

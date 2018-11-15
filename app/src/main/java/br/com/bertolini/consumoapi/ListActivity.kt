package br.com.bertolini.consumoapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.bertolini.consumoapi.model.Pokemon
import br.com.bertolini.consumoapi.model.Sprites
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        rvPokemons.adapter = ListAdapter(listOf(
                Pokemon("Charmander", Sprites((""))),
                        Pokemon("Pikachu", Sprites(("")))
        ), this, {})
        rvPokemons.layoutManager = LinearLayoutManager(this)
    }
}

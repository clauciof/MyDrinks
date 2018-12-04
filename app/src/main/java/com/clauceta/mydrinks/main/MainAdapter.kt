package com.clauceta.mydrinks.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clauceta.mydrinks.entidades.Drinks
import com.clauceta.mydrinks.utils.GlideModule
import com.clauceta.mydrinks.R
import com.clauceta.mydrinks.utils.GlideApp
import kotlinx.android.synthetic.main.main_recyclerview_item.view.*

class MainAdapter(val context: Context, val drink: List<Drinks>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recyclerview_item, parent, false)
        return ViewHolder(view)
    }


    //retorna a qntd itens da lista
    override fun getItemCount(): Int {
        return drink.size
    }


    //popula viewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(context,drink[position])
    }

    //referência para a view de cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context,
                     drink: Drinks) {
            itemView.nome_drink.text = drink.strDrink
            itemView.categoria_drink.text = drink.strCategory
            itemView.tipo_drink.text = drink.strAlcoholic
           // itemView.img_drink.


            GlideApp.with(context)
                    .load(drink.strDrinkThumb)
                    //.placeholder(R.drawable.)
                    .centerCrop()
                    .into(itemView.img_drink)


        }



    }
}
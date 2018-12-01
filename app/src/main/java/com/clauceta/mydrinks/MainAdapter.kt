package com.clauceta.mydrinks

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            itemView.nome_drink.text = drink.nomedrink
            itemView.descricao_drink.text = drink.descricaodrink

        /* Implementar Glide    GlideApp.with(context)
                    .load(article.urlToImage)
                    .placeholder(R.drawable.no_image)
                    .centerCrop()
                    .into(itemView.imgNews)   */


        }



    }
}
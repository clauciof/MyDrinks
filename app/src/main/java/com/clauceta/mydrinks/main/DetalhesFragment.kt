package com.clauceta.mydrinks.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.clauceta.mydrinks.R
import com.clauceta.mydrinks.entidades.Drinks
import com.clauceta.mydrinks.utils.GlideApp
import kotlinx.android.synthetic.main.fragment_detalhes.*
import kotlinx.android.synthetic.main.fragment_main_list.*


class DetalhesFragment : Fragment() {

    companion object {
        val CHAVE_ARG = "arg_list"
        fun newInstance(drink: Drinks) =
                DetalhesFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(CHAVE_ARG, drink)
                    }
                }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalhes, container, false)
    }

    fun getDrink(): Drinks {
        val drinks = arguments?.getSerializable(MainListFragment.CHAVE_ARG) as Drinks?
        if (drinks == null) {
            throw NullPointerException("Drinks can not be null")
        }

        return drinks
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val drink = getDrink()


        activity?.let { that ->
            GlideApp.with(that)
                    .load(drink.strDrinkThumb)
                    .centerCrop()
                    .into(f_drink_detail_img)
        }

        f_drink_detail_nome.text = drink.strDrink
        f_drink_detail_tipo.text = drink.strAlcoholic
        f_drink_categoria.text = drink.strCategory
        ingrediente1.text = drink.strIngredient1
        ingrediente2.text = drink.strIngredient2
        ingrediente3.text = drink.strIngredient3
        ingrediente4.text = drink.strIngredient4
        ingrediente5.text = drink.strIngredient5




    }

}

package com.clauceta.mydrinks.main


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clauceta.mydrinks.R
import com.clauceta.mydrinks.R.id.main_recyclerview
import com.clauceta.mydrinks.entidades.Drinks
import kotlinx.android.synthetic.main.fragment_main_list.*

class MainListFragment : Fragment() {

    companion object {
        val CHAVE_ARG = "arg_list"
        fun newInstance(lista: ArrayList<Drinks>) =
            MainListFragment().apply {
                arguments  = Bundle().apply{
                    putSerializable(CHAVE_ARG, lista)
                }
            }
    }

    var listener: onFragmentInteractionListener? = null

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listaDeDrinks = getDrinksList()

        activity?.let{that->

            val adapter = MainAdapter(that, listaDeDrinks)
           // val layoutManager = LinearLayoutManager(that)
            adapter.listenerClique { position ->
                listener?.onFragmentInteraction(listaDeDrinks[position])
            }

            main_recyclerview.adapter = adapter
            main_recyclerview.layoutManager = LinearLayoutManager(that)


        }

    }

        fun getDrinksList(): ArrayList<Drinks>{
            val drinks = arguments?.getSerializable(CHAVE_ARG) as ArrayList<Drinks>?
            if(drinks == null){
                throw NullPointerException("Drinks list can not be null")
            }

            return drinks
        }

        interface onFragmentInteractionListener{
            fun onFragmentInteraction(lista: Drinks)
        }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(context is MainListFragment.onFragmentInteractionListener){
            listener = context
        }else{
            throw RuntimeException(context.toString())
        }
    }

    override fun onDetach() {
        super.onDetach()

        listener = null
    }


}

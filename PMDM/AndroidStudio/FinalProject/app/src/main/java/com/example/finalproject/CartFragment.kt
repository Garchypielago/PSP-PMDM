package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.FragmentCartBinding
import com.example.finalproject.models.ResponseCart
import com.example.finalproject.recycler.MyCartAdapter
import com.example.finalproject.viewModels.CartViewModel

class CartFragment : Fragment() {
    companion object {
        fun newInstance() = CartFragment()
    }

    private lateinit var binding: FragmentCartBinding
    private val myCartViewModel: CartViewModel by viewModels()
    private lateinit var myAdapter: MyCartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(inflater, container, false)
        val myView = binding.root

        // Inicializamos el adaptador con una lista vacía y el listener para los clicks
        myAdapter = MyCartAdapter(ResponseCart())
        binding.cartRecyclerView.adapter = myAdapter

        with(binding) {
            val layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            cartRecyclerView.layoutManager = layoutManager

            myCartViewModel.returnCart()

            myCartViewModel.data.observe(viewLifecycleOwner) { response ->
                    myAdapter = MyCartAdapter(response)
                    cartRecyclerView.adapter = myAdapter

                    pokeCartTotal.text = "${response.totalPrice}P¥"
//                    pokeCartItems.text = "x${response.totalItems}"
            }

        }

        return myView
    }

}
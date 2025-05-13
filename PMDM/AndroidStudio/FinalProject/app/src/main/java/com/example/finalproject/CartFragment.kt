package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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

    private var firstLoad = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        myCartViewModel.returnCart()
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.bind(view)

        // Inicializamos el adaptador con una lista vacía y el listener para los clicks
        myAdapter = MyCartAdapter(ResponseCart(), myCartViewModel)
        binding.cartRecyclerView.adapter = myAdapter

        with(binding) {
            val layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            cartRecyclerView.layoutManager = layoutManager

            myCartViewModel.data.observe(viewLifecycleOwner) { response ->
                if (firstLoad) {
                    firstLoad = false
                    return@observe
                }

                if (response.products.isEmpty()) {
                    pokeCartTotal.text = "0P¥"
                    Toast.makeText(requireContext(), "Did not find any Pokemon", Toast.LENGTH_LONG)
                        .show()
                    return@observe
                }

                myAdapter = MyCartAdapter(response, myCartViewModel)
                cartRecyclerView.adapter = myAdapter

                pokeCartTotal.text = "${response.totalPrice}P¥"
            }

            myCartViewModel.data2.observe(viewLifecycleOwner) {
                if (!it.isNullOrBlank()) {
                    Toast.makeText(requireContext(), it, Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}
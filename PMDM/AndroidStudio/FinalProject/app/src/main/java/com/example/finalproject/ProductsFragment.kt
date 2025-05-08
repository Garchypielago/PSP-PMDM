package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalproject.databinding.FragmentProductsBinding
import com.example.finalproject.entities.Pokemon
import com.example.finalproject.models.ResponseShopedex
import com.example.finalproject.recycler.MyProductAdapter
import com.example.finalproject.viewModels.ProductsViewModel


class ProductsFragment : Fragment(), AdapterView.OnItemSelectedListener {
    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var binding: FragmentProductsBinding
    private val myProductsViewModel: ProductsViewModel by viewModels()
    private lateinit var myAdapter: MyProductAdapter

    private lateinit var typeSpinner: Spinner
    private lateinit var regionSpinner: Spinner
    private lateinit var typeAdapter: ArrayAdapter<String>
    private lateinit var regionAdapter: ArrayAdapter<String>

    private var type: Int = 0
    private var region: Int = 0

    private var firstLoad = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inicialización del view binding
        binding = FragmentProductsBinding.inflate(inflater, container, false)
        val myView = binding.root

        // Inicializamos el adaptador con una lista vacía y el listener para los clicks
        myAdapter = MyProductAdapter(ResponseShopedex()) { product ->
            // Implementación del listener para cuando se hace click en un producto
            val myIntent = Intent(requireContext(), BuyProductActivity::class.java).apply {
                putExtra("PRODUCT_ID", product.id)
                putExtra("PRODUCT_NAME", product.name)
                putExtra("PRODUCT_IMG", product.url)
                putExtra("PRODUCT_STOCK", product.stock)
                putExtra("PRODUCT_PRICE", product.price)
            }
            startActivity(myIntent)
        }
        binding.productRecyclerView.adapter = myAdapter

        with(binding) {
            // Configuración del LayoutManager para el RecyclerView
            val layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            productRecyclerView.layoutManager = layoutManager

            // Configuración de los adaptadores para los Spinners
            typeAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.type_spinner)
            )
            regionAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_item,
                resources.getStringArray(R.array.region_spinner)
            )
            typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            productTypeSpinner.adapter = typeAdapter
            productRegionSpinner.adapter = regionAdapter
            productTypeSpinner.onItemSelectedListener = this@ProductsFragment
            productRegionSpinner.onItemSelectedListener = this@ProductsFragment
            typeSpinner = productTypeSpinner
            regionSpinner = productRegionSpinner

            // Cargamos todos los productos inicialmente
            myProductsViewModel.returnAllProducts()

            // Listener para el botón de filtrado
            productFilterBtn.setOnClickListener {
                when {
                    type == 0 && region == 0 -> myProductsViewModel.returnAllProducts()
                    type != 0 && region == 0 -> myProductsViewModel.returnTypeProducts(type.toLong())
                    type == 0 && region != 0 -> myProductsViewModel.returnRegionProducts(region.toLong())
                    else -> myProductsViewModel.returnTypeRegionProducts(
                        type.toLong(),
                        region.toLong()
                    )
                }
            }

            myProductsViewModel.data.observe(viewLifecycleOwner) { response ->
                if (firstLoad) {
                    firstLoad = false
                    return@observe
                }

                myAdapter = MyProductAdapter(response) { product ->

                    val myIntent =
                        Intent(requireContext(), BuyProductActivity::class.java).apply {
                            putExtra("PRODUCT_ID", product.id)
                            putExtra("PRODUCT_NAME", product.name)
                            putExtra("PRODUCT_IMG", product.url)
                            putExtra("PRODUCT_STOCK", product.stock)
                            putExtra("PRODUCT_PRICE", product.price)
                        }
                    startActivity(myIntent)
                }
                productRecyclerView.adapter = myAdapter

                if (response.empty) {
                    Toast.makeText(requireContext(), "Did not find any Pokemon", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

        return myView
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (R.id.productTypeSpinner == parent?.id) {
            when (typeSpinner.selectedItem.toString()) {
                "NORMAL" -> type = 1
                "FIGHTING" -> type = 2
                "FLYING" -> type = 3
                "POISON" -> type = 4
                "GROUND" -> type = 5
                "ROCK" -> type = 6
                "BUG" -> type = 7
                "GHOST" -> type = 8
                "STEEL" -> type = 9
                "FIRE" -> type = 10
                "WATER" -> type = 11
                "GRASS" -> type = 12
                "ELECTRIC" -> type = 13
                "PSYCHIC" -> type = 14
                "ICE" -> type = 15
                "DRAGON" -> type = 16
                "DARK" -> type = 17
                "FAIRY" -> type = 18
                else -> type = 0
            }
        }

        if (R.id.productRegionSpinner == parent?.id) {
            when (regionSpinner.selectedItem.toString()) {
                "KANTO" -> region = 1
                "JOHTO" -> region = 2
                "HOENN" -> region = 3
                "SINNOH" -> region = 4
                "TESELIA" -> region = 5
                "KALOS" -> region = 6
                "ALOLA" -> region = 7
                "GALAR" -> region = 8
                "PALDEA" -> region = 9
                else -> region = 0
            }
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
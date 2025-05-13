package com.example.finalproject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.finalproject.databinding.ActivityBuyProductBinding
import com.example.finalproject.viewModels.CartViewModel

class BuyProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBuyProductBinding

    private val myCartViewModel: CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityBuyProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.buymain) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val productId = intent.getIntExtra("PRODUCT_ID", 1).toLong()
        val productName = intent.getStringExtra("PRODUCT_NAME")
        val productImg = intent.getStringExtra("PRODUCT_IMG")
        val productStock = intent.getIntExtra("PRODUCT_STOCK", 0)
        val productPrice = intent.getDoubleExtra("PRODUCT_PRICE", 0.0)


        with(binding) {

            val url: String = productImg.toString()
            Glide.with(this@BuyProductActivity)
                .load(url)
                .into(buyImg)

            buyName.text = productName
            buyStock.text = productStock.toString()
            buyPrice.text = "${productPrice}P¥"


            buyCloseBtn.setOnClickListener {
                this@BuyProductActivity.finish()
            }

            buyBtn.setOnClickListener {
                buyBtn.isEnabled = false
                val quant = buyQuantity.text.toString().toLong()

                myCartViewModel.addProductToCart(productId, quant)
            }

            myCartViewModel.data2.observe(this@BuyProductActivity) {
                if (!it.isNullOrBlank()) {
                    Toast.makeText(this@BuyProductActivity, it, Toast.LENGTH_LONG).show()
                    if (!it.contains("Error", ignoreCase = true)) {
                        this@BuyProductActivity.finish()
                    }
                }
                buyBtn.isEnabled = true
            }
        }

    }
}
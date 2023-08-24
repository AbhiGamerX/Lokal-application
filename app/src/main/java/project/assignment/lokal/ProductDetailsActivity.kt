package project.assignment.lokal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductDetailsActivity : AppCompatActivity()
{
    lateinit var adapter: ProductsAdapter
    lateinit var prodImage: ImageView
    lateinit var prodName: TextView
    lateinit var prodDesc: TextView
    lateinit var prodPrice: TextView
    lateinit var prodRating: TextView
    lateinit var prodDisc: TextView
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details_layout)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.app_actionbar_layout)

        prodImage = findViewById(R.id.productImage)
        prodName = findViewById(R.id.productName)
        prodDesc = findViewById(R.id.productDescription)
        prodPrice = findViewById(R.id.productPrice)
        prodRating = findViewById(R.id.productRating)
        prodDisc = findViewById(R.id.productDiscount)

    }
}
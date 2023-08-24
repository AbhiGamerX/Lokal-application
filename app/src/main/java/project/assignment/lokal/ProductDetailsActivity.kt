package project.assignment.lokal

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

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

        val bundle = intent.extras
        if (bundle != null)
        {
            val img: Int = bundle.getInt("thumbnail")
            prodName.text = bundle.getString("title")
            prodDesc.text = bundle.getString("description")
            prodPrice.text = bundle.getString("price")
            prodRating.text = bundle.getString("rating")
            prodDisc.text = bundle.getString("discount")
            prodImage.setImageResource(img)
        }
    }

    override fun onBackPressed()    // On Back Button Press going to either Main Activity or Second Activity
    {
        super.onBackPressed()
        intent = Intent(this, ProductViewActivity::class.java)
        startActivity(intent)
    }
}
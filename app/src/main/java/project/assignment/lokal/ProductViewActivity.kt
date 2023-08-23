package project.assignment.lokal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewActivity : AppCompatActivity()
{
    lateinit var adapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_view_layout)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setCustomView(R.layout.app_actionbar_layout)

        getProduct()
    }

    override fun onBackPressed()
    {
        super.onBackPressed()
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun getProduct()
    {
        val listOfProducts: Call<Products> = ProductsRetroFit.apiInterface.getProducts()
        listOfProducts.enqueue(object : Callback<Products>
        {
            override fun onResponse(call: Call<Products>, response: Response<Products>)
            {
                val temp : Products? = response.body()
                if (temp != null)
                {
                    //Toast.makeText(this@ProductViewActivity, R.string.apinonempty, Toast.LENGTH_SHORT).show()
                    adapter = ProductsAdapter(this@ProductViewActivity, temp.products)
                    val recyclerView = findViewById<View>(R.id.productList) as RecyclerView
                    recyclerView.adapter = adapter
                    recyclerView.layoutManager = LinearLayoutManager(this@ProductViewActivity)
                }
                else
                {
                    Toast.makeText(this@ProductViewActivity, R.string.apiempty, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<Products>, t: Throwable)
            {
                Toast.makeText(this@ProductViewActivity, t.localizedMessage, Toast.LENGTH_LONG).show()
                Log.ERROR
            }

        })
    }
}
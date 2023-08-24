package project.assignment.lokal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductsAdapter(val context: Context, val products: List<ProductList>) : RecyclerView.Adapter<ProductsAdapter.ArticleViewHolder>(), OnClickListener
{
    var temp = products[0]
    class ArticleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var productImage = itemView.findViewById<ImageView>(R.id.productImage)
        var productName = itemView.findViewById<TextView>(R.id.productName)
        var productDesc = itemView.findViewById<TextView>(R.id.productDescription)
        var productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        var productDisc = itemView.findViewById<TextView>(R.id.productDiscount)
        var productRat = itemView.findViewById<TextView>(R.id.productRating)
        var cardViewLayout = itemView.findViewById<CardView>(R.id.cardView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder    // Creating ViewHolder to inflate data into Recycle View
    {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return products.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int)     // Binding Data to respective Views
    {
        val productPos = products[position]
        temp = productPos
        holder.productName.text = productPos.title
        holder.productDesc.text = productPos.description
        holder.productPrice.text = productPos.price.toString()
        holder.productDisc.text = productPos.discountPercentage.toString()
        holder.productRat.text = productPos.rating.toString()
        Glide.with(context).load(productPos.thumbnail).into(holder.productImage)
        holder.cardViewLayout.setOnClickListener(this)
        /*holder.cardViewLayout.setOnClickListener(View.OnClickListener()
        {
            fun onClick(view: View)
            {
                //Toast.makeText(context, "Item Selected", Toast.LENGTH_LONG).show()
                val bundle = Bundle()
                val intent = Intent(context, ProductDetailsActivity::class.java)
                bundle.putString("title", temp.title)
                bundle.putString("description", temp.description)
                bundle.putString("price", temp.price.toString())
                bundle.putString("discount", temp.discountPercentage.toString())
                bundle.putString("rating", temp.rating.toString())
                bundle.putString("thumbnail", temp.thumbnail)
                intent.putExtras(intent)
                context.startActivity(intent)
            }
        })*/
    }

    override fun onClick(v: View?) // Overriding OnClick Function to listen for Click
    {
        //Toast.makeText(context, "Item Selected", Toast.LENGTH_LONG).show()
        val bundle = Bundle()
        val intent = Intent(context, ProductDetailsActivity::class.java)
        bundle.putString("title", temp.title)
        bundle.putString("description", temp.description)
        bundle.putString("price", temp.price.toString())
        bundle.putString("discount", temp.discountPercentage.toString())
        bundle.putString("rating", temp.rating.toString())
        intent.putExtra("thumbnail", temp.thumbnail)
        intent.putExtras(bundle)
        context.startActivity(intent)
    }

}


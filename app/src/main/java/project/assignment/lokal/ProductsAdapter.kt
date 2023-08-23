package project.assignment.lokal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductsAdapter(val context: Context,val products: List<ProductList>) : RecyclerView.Adapter<ProductsAdapter.ArticleViewHolder>()
{
    class ArticleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var productImage = itemView.findViewById<ImageView>(R.id.productImage)
        var productName = itemView.findViewById<TextView>(R.id.productName)
        var productDesc = itemView.findViewById<TextView>(R.id.productDescription)
        var productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        var productDisc = itemView.findViewById<TextView>(R.id.productDiscount)
        var productRat = itemView.findViewById<TextView>(R.id.productRating)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder
    {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int
    {
        return products.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int)
    {
        val productPos = products[position]
        holder.productName.text = productPos.title
        holder.productDesc.text = productPos.description
        holder.productPrice.text = productPos.price.toString()
        holder.productDisc.text = productPos.discountPercentage.toString()
        holder.productRat.text = productPos.rating.toString()
        Glide.with(context).load(productPos.thumbnail).into(holder.productImage)
    }

}

/*
class ProductsAdapter(private val products: List<Products>) : RecyclerView.Adapter<ProductsAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var productImage = itemView.findViewById<ImageView>(R.id.productImage)
        var productName = itemView.findViewById<TextView>(R.id.productName)
        var productDesc = itemView.findViewById<TextView>(R.id.productDescription)
        var productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        var productDisc = itemView.findViewById<TextView>(R.id.productDiscount)
        var productRat = itemView.findViewById<TextView>(R.id.productRating)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val productPos = products[position]
        holder.productName.text = productPos.title
        holder.productDesc.text = productPos.description
        holder.productPrice.text = productPos.price.toString()
        holder.productDisc.text = productPos.discountPercentage.toString()
        holder.productRat.text = productPos.rating.toString()
        //Glide.with(context).load(productPos.thumbnail).into(holder.productImage)
    }

    override fun getItemCount(): Int = products.size

}*/

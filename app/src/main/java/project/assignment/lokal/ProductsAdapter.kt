package project.assignment.lokal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ProductsAdapter(val context: Context, val products: List<ProductList>) : RecyclerView.Adapter<ProductsAdapter.ArticleViewHolder>()
{
    private var onClickListener: OnClickListener? = null
    class ArticleViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        var productImage = itemView.findViewById<ImageView>(R.id.productImage)
        var productName = itemView.findViewById<TextView>(R.id.productName)
        var productDesc = itemView.findViewById<TextView>(R.id.productDescription)
        var productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        var productDisc = itemView.findViewById<TextView>(R.id.productDiscount)
        var productRat = itemView.findViewById<TextView>(R.id.productRating)

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
        holder.productName.text = productPos.title
        holder.productDesc.text = productPos.description
        holder.productPrice.text = productPos.price.toString()
        holder.productDisc.text = productPos.discountPercentage.toString()
        holder.productRat.text = productPos.rating.toString()
        Glide.with(context).load(productPos.thumbnail).into(holder.productImage)
        holder.itemView.setOnClickListener()
        {
            if (onClickListener != null)
                onClickListener!!.onClick(position, productPos)
        }
    }
    fun setOnClickListener(onClickListener: OnClickListener)
    {
        this.onClickListener = onClickListener
    }

    interface OnClickListener
    {
        fun onClick(position: Int, products: ProductList)
    }

}


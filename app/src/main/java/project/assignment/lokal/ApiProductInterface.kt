package project.assignment.lokal

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://dummyjson.com/"
const val product = "products"
//const val API_KEY = ""
interface ApiProductInterface
{
    @GET(product) // Sending Query to get product list
    fun getProducts() : Call<Products> // Calling Data Class
}
package project.assignment.lokal

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create

object ProductsRetroFit
{
    val apiInterface: ApiProductInterface
    init
    {
        //val gson = GsonBuilder().setLenient().create()
        //val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build()
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        apiInterface = retrofit.create(ApiProductInterface::class.java)
    }
}
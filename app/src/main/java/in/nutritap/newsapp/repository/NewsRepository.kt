package`in`.nutritap.newsapp.repository

import `in`.nutritap.newsapp.model.Article
import `in`.nutritap.newsapp.network.ApiInterface
import `in`.nutritap.newsapp.network.RetrofitService
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NewsRepository {

    val newsModel = MutableLiveData<Article>()

    fun getNewsList():MutableLiveData<Article> {

        val call = RetrofitService.createService(ApiInterface::class.java)

        call.getNews("us","6d3def67c8d04ee8a1e3e2f1258ddb8c").enqueue(object : Callback<Article?> {
            override fun onResponse(call: Call<Article?>, response: Response<Article?>) {
                if (response.isSuccessful)
                newsModel.value = response.body()
            }

            override fun onFailure(call: Call<Article?>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        return newsModel
    }

    /*private var newsRepository: NewsRepository? = null


    fun getInstance(): NewsRepository? {
        return if (newsRepository != null) {
            newsRepository
        } else {
            newsRepository = NewsRepository()
            newsRepository
        }
    }

    constructor(apiInterface: ApiInterface) : this( apiInterface)*/

}
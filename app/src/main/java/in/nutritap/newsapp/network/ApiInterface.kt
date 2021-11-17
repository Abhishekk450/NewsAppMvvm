package`in`.nutritap.newsapp.network
import `in`.nutritap.newsapp.model.Article
import `in`.nutritap.newsapp.model.NewsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiInterface {
    @GET("top-headlines")
    fun getNews(@Query("country") counrty:String, @Query("apiKey") apiKey:String):Call<Article>
}
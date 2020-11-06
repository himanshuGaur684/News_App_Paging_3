package gaur.himanshu.august.paging3.networking

import gaur.himanshu.august.paging3.model.networkdomain.NetworkNewsModel
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkCalls {


    @GET("top-headlines")
    fun getNews(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String
    ): Deferred<NetworkNewsModel>


}
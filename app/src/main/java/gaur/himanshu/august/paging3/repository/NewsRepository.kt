package gaur.himanshu.august.paging3.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import gaur.himanshu.august.paging3.model.networkdomain.Article
import gaur.himanshu.august.paging3.model.networkdomain.NetworkNewsModel
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel
import gaur.himanshu.august.paging3.networking.NetworkCalls
import gaur.himanshu.august.paging3.room.NewsDao
import gaur.himanshu.august.paging3.utils.asRoomDomainModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val newsDao: NewsDao,
    private val networkCalls: NetworkCalls
) {

    val bool = MutableLiveData<Boolean>()

    val API_KEY = "436a7b507ee5433bafa1ad67c8eff93b"
    val COUNTRY = "in"
    val CATEGORY = "business"

    suspend fun fetchAndCacheNews() {
        bool.value = true
        withContext(IO) {
            try {
                Log.d(TAG, "fetchAndCacheNews: ")
                val networkNewsModel: NetworkNewsModel =
                    networkCalls.getNews(COUNTRY, CATEGORY, API_KEY).await()
                Log.d(TAG, "fetchAndCacheNews: ${networkNewsModel.articles.size}")
                val list: List<Article> = networkNewsModel.articles
                val roomDomainList: List<NewsRoomModel> = list.asRoomDomainModel()

                Log.d(TAG, "fetchAndCacheNews: ${list.size}")
                newsDao.insertList(roomDomainList)
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {


            }


        }
        bool.value = false
    }


}
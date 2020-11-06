package gaur.himanshu.august.paging3.room

import androidx.paging.PagingSource
import androidx.room.*
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel

@Dao
interface NewsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertList(newsRoomModel: List<NewsRoomModel>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(newsRoomModel: NewsRoomModel)


    @Delete
    suspend fun delete(newsRoomModel: NewsRoomModel)

    @Query("SELECT * FROM NewsRoomModel")
    fun getPages(): PagingSource<Int, NewsRoomModel>

}
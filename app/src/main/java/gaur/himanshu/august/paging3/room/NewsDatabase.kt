package gaur.himanshu.august.paging3.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel

@Database(entities = [NewsRoomModel::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    companion object {
        fun get(context: Context): NewsDatabase {
            return Room.databaseBuilder(context, NewsDatabase::class.java, "news_db")
                .fallbackToDestructiveMigration().build()
        }
    }

    abstract fun getNewsDao(): NewsDao

}
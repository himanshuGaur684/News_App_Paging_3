package gaur.himanshu.august.paging3.hilt.modules

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import gaur.himanshu.august.paging3.networking.NetworkCalls
import gaur.himanshu.august.paging3.repository.NewsRepository
import gaur.himanshu.august.paging3.room.NewsDao
import gaur.himanshu.august.paging3.room.NewsDatabase
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


const val BASE_URL = "https://newsapi.org/v2/"

@Module
@InstallIn(ApplicationComponent::class)
object HiltModules {

    @Provides
    fun provideRepository(newsDao: NewsDao, networkCalls: NetworkCalls): NewsRepository {
        return NewsRepository(newsDao = newsDao, networkCalls)
    }


    @Provides
    fun provideNoteDao(newsDatabase: NewsDatabase): NewsDao {
        return newsDatabase.getNewsDao()
    }

    @Provides
    fun provideNewsDatabase(@ApplicationContext context: Context): NewsDatabase {
        return NewsDatabase.get(context)
    }

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun provideNetworkCall(retrofit: Retrofit): NetworkCalls {
        return retrofit.create(NetworkCalls::class.java)
    }

}
package gaur.himanshu.august.paging3.viewmodels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import gaur.himanshu.august.paging3.repository.NewsRepository
import gaur.himanshu.august.paging3.room.NewsDao
import kotlinx.coroutines.launch


class NewsViewModels @ViewModelInject constructor(
    private val newsRepository: NewsRepository,
    private val newsDao: NewsDao,
    @Assisted savedStateHandle: SavedStateHandle
) : ViewModel() {

    val flow = Pager(
        PagingConfig(pageSize = 10)
    ) {
        newsDao.getPages()
    }.flow
        .cachedIn(viewModelScope)


    fun fetchAndCacheNews() {
        viewModelScope.launch {
            newsRepository.fetchAndCacheNews()

        }
    }

    fun getBool(): MutableLiveData<Boolean> {
        return newsRepository.bool
    }

}
package gaur.himanshu.august.paging3.utils

import gaur.himanshu.august.paging3.model.localdomain.News
import gaur.himanshu.august.paging3.model.networkdomain.Article
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel

fun List<Article>.asRoomDomainModel(): List<NewsRoomModel> {
    return map {
        NewsRoomModel(
            author = it.author,
            content = it.content,
            description = it.description,
            publishedAt = it.publishedAt,
            title = it.title!!,
            url = it.url,
            urlToImage = it.urlToImage
        )
    }
}

fun List<NewsRoomModel>.asLocalDomainModel(): List<News> {
    return map {
        News(

            author = it.author!!,
            content = it.content!!,
            description = it.description!!,
            publishedAt = it.publishedAt!!,
            title = it.title,
            url = it.url!!,
            urlToImage = it.urlToImage!!
        )
    }
}
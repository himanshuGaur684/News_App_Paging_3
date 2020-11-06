package gaur.himanshu.august.paging3.model.networkdomain

data class NetworkNewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
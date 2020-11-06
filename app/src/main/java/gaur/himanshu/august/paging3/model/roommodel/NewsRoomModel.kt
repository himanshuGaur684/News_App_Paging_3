package gaur.himanshu.august.paging3.model.roommodel

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class NewsRoomModel(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    @PrimaryKey(autoGenerate = false)
    val title: String,
    val url: String?,
    val urlToImage: String?
) : Parcelable {


}
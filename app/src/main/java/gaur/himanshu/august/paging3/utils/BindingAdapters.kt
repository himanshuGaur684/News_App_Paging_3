package gaur.himanshu.august.paging3.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import gaur.himanshu.august.paging3.R

@BindingAdapter("glide")
fun glides(view: ImageView, url: String?) {
    if (url == null) return
    Glide.with(view).load(url).error(R.drawable.ic_launcher_background).into(view)
}
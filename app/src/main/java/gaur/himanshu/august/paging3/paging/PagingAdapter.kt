package gaur.himanshu.august.paging3.paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.paging3.BR
import gaur.himanshu.august.paging3.databinding.ListItemNewsBinding
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel

class PagingAdapter() :
    PagingDataAdapter<NewsRoomModel, PagingAdapter.AdapterViewHolder>(diffCallback) {

    inner class AdapterViewHolder(private val viewDataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(newsRoomModel: NewsRoomModel) {
            viewDataBinding.setVariable(BR.news, newsRoomModel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val binding =
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<NewsRoomModel>() {
            override fun areItemsTheSame(oldItem: NewsRoomModel, newItem: NewsRoomModel): Boolean =
                oldItem.url == newItem.url

            override fun areContentsTheSame(
                oldItem: NewsRoomModel,
                newItem: NewsRoomModel
            ): Boolean =
                oldItem.url == newItem.url
        }
    }

}
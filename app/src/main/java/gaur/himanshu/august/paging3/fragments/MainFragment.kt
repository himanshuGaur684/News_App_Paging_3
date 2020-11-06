package gaur.himanshu.august.paging3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.paging3.databinding.FragmentMainBinding
import gaur.himanshu.august.paging3.paging.PagingAdapter
import gaur.himanshu.august.paging3.viewmodels.NewsViewModels
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    lateinit var navController: NavController

    val viewModel: NewsViewModels by viewModels()

    val pagingAdapter = PagingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)

        viewModel.fetchAndCacheNews()

        CoroutineScope(Main).launch {
            viewModel.getBool().observe(viewLifecycleOwner, {
                if (!it) {
                    viewLifecycleOwner.lifecycleScope.launch {
                        viewModel.flow.collectLatest {

                            pagingAdapter.submitData(it)
                            pagingAdapter.refresh()

                        }
                    }
                }
            })

            binding.recycler.adapter = pagingAdapter
        }
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
    }

}
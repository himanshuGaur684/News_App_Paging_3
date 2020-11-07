package gaur.himanshu.august.paging3.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.paging3.R
import gaur.himanshu.august.paging3.databinding.FragmentDetailsBinding
import gaur.himanshu.august.paging3.model.roommodel.NewsRoomModel

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    lateinit var navController: NavController

    val args by navArgs<DetailsFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding=FragmentDetailsBinding.inflate(inflater,container,false)

        binding.newsRoomModel = args.newsRoomModel

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController= Navigation.findNavController(view)
    }

}
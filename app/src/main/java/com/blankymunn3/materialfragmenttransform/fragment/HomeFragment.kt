package com.blankymunn3.materialfragmenttransform.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.blankymunn3.materialfragmenttransform.adapter.BTSRVAdapter
import com.blankymunn3.materialfragmenttransform.databinding.FragmentHomeBinding
import com.blankymunn3.materialfragmenttransform.model.btsList
import com.google.android.material.transition.MaterialFadeThrough

class HomeFragment: Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get()  = _binding!!
    lateinit var btsRVAdapter: BTSRVAdapter

    var isReload = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enterTransition = MaterialFadeThrough()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        if (!isReload) {
            _binding = FragmentHomeBinding.inflate(inflater, container, false)
            binding.lifecycleOwner = this

        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isReload) {
            isReload = true
            btsRVAdapter = BTSRVAdapter(btsList)
            binding.rvBts.apply {
                layoutManager = GridLayoutManager(requireContext(), 3)
                setHasFixedSize(true)
                isNestedScrollingEnabled = false
                adapter = btsRVAdapter
            }

            btsRVAdapter.onBTSClickListener(object : BTSRVAdapter.BTSClickListener {
                override fun onClick(uId: Int, cardView: CardView) {
                    val extras = FragmentNavigatorExtras(cardView to uId.toString())
                    val action = HomeFragmentDirections.navToHomeSecondFragment(uId)
                    findNavController().navigate(action, extras)
                }

            })
        }
    }
}
package com.blankymunn3.materialfragmenttransform.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.navigation.fragment.navArgs
import com.blankymunn3.materialfragmenttransform.R
import com.blankymunn3.materialfragmenttransform.databinding.FragmentHomeSecBinding
import com.blankymunn3.materialfragmenttransform.model.btsList
import com.google.android.material.color.MaterialColors
import com.google.android.material.transition.MaterialContainerTransform

class HomeSecFragment:Fragment() {
    private val args: HomeSecFragmentArgs by navArgs()
    private var _binding: FragmentHomeSecBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = buildContainerTransform()
        sharedElementReturnTransition = buildContainerTransform()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeSecBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.layoutBts.transitionName = args.pictureUid.toString()
        val btsModel = btsList.find { it.uId == args.pictureUid }
        binding.bts = btsModel

    }

    private fun buildContainerTransform() =
        MaterialContainerTransform().apply {
            drawingViewId = R.id.nav_host_fragment_container
            interpolator = FastOutSlowInInterpolator()
            containerColor = MaterialColors.getColor(requireActivity().findViewById(android.R.id.content), R.attr.colorSurface)
            fadeMode = MaterialContainerTransform.FADE_MODE_OUT
            duration = 300
        }
}
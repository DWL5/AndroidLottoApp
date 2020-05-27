package com.yellowlego.lottoapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.yellowlego.lottoapp.R
import com.yellowlego.lottoapp.ui.constellation.ConstellationFragmentDirections
import com.yellowlego.lottoapp.utils.LottoNumberMaker
import kotlinx.android.synthetic.main.fragment_constelleation.*
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.home_fragment.view.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.home_fragment, container, false)
        v.randomCard.setOnClickListener {
            val action = HomeFragmentDirections
                .actionHomeFragmentToResultFragment(
                    LottoNumberMaker.getRandomLottoNumbers().toIntArray())
            findNavController().navigate(action)
        }

        v.constrallationCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_constelleationFragment)
        }

        v.nameCard.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_nameFragment)
        }
        return v
    }
}


package com.yellowlego.lottoapp.ui.name

import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.yellowlego.lottoapp.R
import com.yellowlego.lottoapp.utils.LottoNumberMaker
import kotlinx.android.synthetic.main.fragment_constelleation.*
import kotlinx.android.synthetic.main.fragment_name.*

/**
 * A simple [Fragment] subclass.
 */
class NameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val localInflater: LayoutInflater? = activity?.layoutInflater?.cloneInContext(
            ContextThemeWrapper(
                activity,
                R.style.AppTheme_Name
            )
        )
        val v: View? = localInflater?.inflate(R.layout.fragment_name, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        goButton.setOnClickListener {
            val action = NameFragmentDirections.actionNameFragmentToResultFragment(
                LottoNumberMaker.getLottoNumbersFromHash(editText.text.toString()).toIntArray()
            )
            findNavController().navigate(action)
        }

        backButton.setOnClickListener {
            findNavController().navigate(R.id.action_nameFragment_to_homeFragment)
        }
    }
}

package com.yellowlego.lottoapp.ui.constellation


import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CalendarView
import android.widget.DatePicker
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController

import com.yellowlego.lottoapp.R
import com.yellowlego.lottoapp.databinding.FragmentConstelleationBinding
import com.yellowlego.lottoapp.utils.LottoNumberMaker
import kotlinx.android.synthetic.main.fragment_constelleation.*
import java.util.*

class ConstellationFragment : Fragment() {

    lateinit var viewModel: ConstellationViewModel
    lateinit var binding: FragmentConstelleationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val localInflater: LayoutInflater? = activity?.layoutInflater?.cloneInContext(
            ContextThemeWrapper(
                activity,
                R.style.AppTheme_Constellation
            )
        )
        val v: View? = localInflater?.inflate(R.layout.fragment_constelleation, container, false)

        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this)[ConstellationViewModel::class.java]
        btnResult.setOnClickListener {
            val action = ConstellationFragmentDirections
                .actionConstelleationFragmentToResultFragment(
                    LottoNumberMaker
                        .getLottoNumbersFromHash(
                            viewModel
                                .getConstellationString(datePicker.month, datePicker.dayOfMonth)
                        )
                        .toIntArray()
                )
            findNavController().navigate(action)
        }


        val cal = Calendar.getInstance()
        datePicker.init(cal.get(Calendar.YEAR),
            cal.get(Calendar.MONTH),
            cal.get(Calendar.DAY_OF_MONTH),
            object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener {
                override fun onSelectedDayChange(
                    view: CalendarView,
                    year: Int,
                    month: Int,
                    dayOfMonth: Int
                ) {
                    textView.text =
                        viewModel.getConstellationString(datePicker.month, datePicker.dayOfMonth);
                }

                override fun onDateChanged(
                    view: DatePicker?,
                    year: Int,
                    monthOfYear: Int,
                    dayOfMonth: Int
                ) {
                }

            })
        textView.text = viewModel.getConstellationString(datePicker.month, datePicker.dayOfMonth)
    }
}

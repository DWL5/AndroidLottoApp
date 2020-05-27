package com.yellowlego.lottoapp.ui.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yellowlego.lottoapp.R
import java.text.SimpleDateFormat
import java.util.*

class ResultViewModel : ViewModel() {
    val number1 = MutableLiveData<Int>()
    val number2 = MutableLiveData<Int>()
    val number3 = MutableLiveData<Int>()
    val number4 = MutableLiveData<Int>()
    val number5 = MutableLiveData<Int>()
    val number6 = MutableLiveData<Int>()

    fun updateLottoBallImage(result: IntArray) {
        if (result.size < 6) return
        number1.value = R.drawable.ball_01 + result[0] - 1
        number2.value = R.drawable.ball_01 + result[1] - 1
        number3.value = R.drawable.ball_01 + result[2] - 1
        number4.value = R.drawable.ball_01 + result[3] - 1
        number5.value = R.drawable.ball_01 + result[4] - 1
        number6.value = R.drawable.ball_01 + result[5] - 1
    }
}
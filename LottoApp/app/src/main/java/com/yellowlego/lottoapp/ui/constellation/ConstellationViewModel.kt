package com.yellowlego.lottoapp.ui.constellation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ConstellationViewModel : ViewModel() {

    private val constellation: MutableLiveData<String> = MutableLiveData()

    fun getConstellationString(month: Int, day: Int) : String {
        val target = "${month + 1}${String.format("%02d", day)}".toInt()
        val result = when (target) {
            in 101..119 -> "염소자리"
            in 120..218 -> "물병자리"
            in 219..320 -> "물고기자리"
            in 321..419 -> "양자리"
            in 420..520 -> "황소자리"
            in 521..621 -> "쌍둥이자리"
            in 622..722 -> "게자리"
            in 723..822 -> "사자자리"
            in 823..923 -> "처녀자리"
            in 924..1022 -> "천칭자리"
            in 1023..1122 -> "전갈자리"
            in 1123..1224 -> "사수자리"
            in 1225..1231 -> "염소자리"
            else -> "기타별자리"
        }
        constellation.value = result
        return result
    }

    fun getConstellation():LiveData<String> {
        return constellation
    }



}
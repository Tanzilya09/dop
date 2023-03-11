package com.example.dop

import android.text.SpannableStringBuilder
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private var _number=MutableLiveData<Int>()
    var number: LiveData<Int> =_number

    var count=0

    fun setMinus(){
        count--
        _number.value=count
    }

    fun setPlus(){
        count++
        _number.value=count
    }
    fun colors(){
       when(count){
           count->SpannableStringBuilder("10")
       }
    }

}
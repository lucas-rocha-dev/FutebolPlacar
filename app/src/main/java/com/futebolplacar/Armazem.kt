package com.futebolplacar

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue


object Armazem {

    private var _lastClickTime = mutableLongStateOf(0L)

    private var _columView by mutableStateOf(false)
    private var _selectCampeonato by mutableStateOf(true)






    var columView: Boolean
        get() = _columView
        set(value) {
            _columView = value
        }

    var lastClickTime: Long
        get() = _lastClickTime.longValue
        set(value) {
            _lastClickTime.longValue = value
        }

    var selectCampeonato: Boolean
        get() = _selectCampeonato
        set(value) {
            _selectCampeonato = value
        }




}
package com.example.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _dataList: MutableLiveData<Array<String>> = MutableLiveData(Array(9) {""})
    val dataList: LiveData<Array<String>> = _dataList

    private val _check = MutableLiveData("")
    val check: LiveData<String> = _check

    fun checkValue(index:Int) {
        if (_check.value == "") {
            _check.value = "X"
        } else if (_check.value == "X") {
            _check.value = "O"
        } else if (_check.value == "O") {
            _check.value = "X"
        }

        val data = _dataList.value
        if (index == 10) {
            for (i in 0..8) {
                data!![i] = ""
            }
            _check.value = ""
        } else {data!![index] = _check.value.toString()}
        _dataList.value = data
    }

    private val _state = MutableLiveData("PLAYING...")
    val state: LiveData<String> = _state

    fun showResult (c1:String, c2:String,c3:String, c4:String,c5:String,c6:String,c7:String,c8:String,c9:String) {

        if (c1 == "" && c2 == "" && c3 == "" && c4 == "" && c5 == "" && c6 == "" && c7 == "" && c8 == "" && c9 == "") {
            _state.value = "PLAYING..."
        }

        else if ((c1 == c2 && c2 == c3) || (c1 == c4 && c4 == c7)) {
            if (c1 =="X") {
                _state.value = "PLAYER X WIN!"
            } else if (c1 =="O") {
                _state.value = "PLAYER O WIN!"
            }
        }

        else if ((c1 == c5 && c5 == c9) || (c3 == c5 && c5 == c7) || (c2 == c5 && c5 == c8) || (c4 == c5 && c5 == c6)) {
            if (c5 =="X") {
                _state.value = "PLAYER X WIN!"
            } else if (c5 =="O") {
                _state.value = "PLAYER O WIN!"
            }
        }

        else if ((c3 == c6 && c6 == c9) || (c7 == c8 && c8 == c9)) {
            if (c9 =="X") {
                _state.value = "PLAYER X WIN!"
            } else if (c9 =="O") {
                _state.value = "PLAYER O WIN!"
            }
        }

        else if (c1 != "" && c2 != "" && c3 != "" && c4 != "" && c5 != "" && c6 != "" && c7 != "" && c8 != "" && c9 != "") {
            _state.value = "DRAW!"
        }
    }

}



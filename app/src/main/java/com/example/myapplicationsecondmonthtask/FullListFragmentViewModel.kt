package com.example.myapplicationsecondmonthtask

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FullListFragmentViewModel : ViewModel() {

    var tempList = MutableLiveData <ArrayList <Posts>> ()

    fun getFullListDate () : LiveData <ArrayList <Posts> > {
        tempList = FullListFragmentRepository.getFullData()
        return tempList
    }
}
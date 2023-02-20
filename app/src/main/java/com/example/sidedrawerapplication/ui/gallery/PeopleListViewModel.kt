package com.example.sidedrawerapplication.ui.gallery

import com.example.sidedrawerapplication.data.model.person.Person
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sidedrawerapplication.data.remote.ApiDetail
import com.example.sidedrawerapplication.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleListViewModel @Inject constructor(
    private val apiDetail: ApiDetail
) : ViewModel() {

    private val _peopleList = MutableLiveData<NetworkResult<Person>>()
    val peopleList
        get() = _peopleList

    fun getPeopleList() {
        viewModelScope.launch {
            _peopleList.value = NetworkResult.Loading()
            val result = apiDetail.getPeople()
            if (result.isSuccessful)
                _peopleList.value = NetworkResult.Success(result.body())
            else
                _peopleList.value = NetworkResult.Error(result.body(), result.message())
        }
    }
}
package com.example.mysubscribers.ui.subscriberslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysubscribers.data.db.entity.SubscriberEntity
import com.example.mysubscribers.repository.SubscriberRepository
import com.example.mysubscribers.ui.subscriber.SubscriberViewModel
import kotlinx.coroutines.launch

class SubscriberListViewModel(
    private val repository: SubscriberRepository
) : ViewModel() {

    private val _allSubscribersEvent = MutableLiveData<List<SubscriberEntity>>()
    val allSubscribersEvent: LiveData<List<SubscriberEntity>>
        get() = _allSubscribersEvent

    fun getAllSubscriber() = viewModelScope.launch {
        _allSubscribersEvent.postValue(repository.getAllSubscriber())
    }

}
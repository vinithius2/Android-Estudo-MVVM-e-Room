package com.example.mysubscribers.ui.subscriber

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mysubscribers.R
import com.example.mysubscribers.repository.SubscriberDataRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(
    private val reporitory: SubscriberDataRepository
) : ViewModel() {

    private val _subscriberStateEventData = MutableLiveData<SubscriberState>()
    val subscriberStateEventData: LiveData<SubscriberState>
        get() = _subscriberStateEventData

    private val _messageEventData  = MutableLiveData<Int>()
    val messageEventData : LiveData<Int>
        get() = _messageEventData

    fun addOrUpdateSubscriber(name: String, email: String, id: Long = 0) {
        if (id > 0) {
            updateSubscriber(id, name, email)
        } else {
            insertSubscriber(name, email)
        }
    }

    fun updateSubscriber(id: Long, name: String, email: String) = viewModelScope.launch {
        try {
            val id = reporitory.updateSubscriber(id, name, email)
            _subscriberStateEventData.value = SubscriberState.Update
            _messageEventData.value = R.string.subscriber_updated_sucessfully
        } catch (ex: Exception) {
            _messageEventData.value = R.string.subscriber_error_to_update
            Log.e(TAG, ex.toString())
        }
    }

    fun insertSubscriber(name: String, email: String) = viewModelScope.launch {
        try {
            val id = reporitory.insertSubscriber(name, email)
            if (id > 0) {
                _subscriberStateEventData.value = SubscriberState.Inserted
                _messageEventData.value = R.string.subscriber_inserted_sucessfully
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.subscriber_error_to_insert
            Log.e(TAG, ex.toString())
        }
    }

    fun deleteSubscriber(id: Long) = viewModelScope.launch {
        try {
            if (id > 0) {
                reporitory.deleteSubscriber(id)
                _subscriberStateEventData.value = SubscriberState.Deleted
                _messageEventData.value = R.string.subscriber_deleted_sucessfully
            }
        } catch (ex: Exception) {
            _messageEventData.value = R.string.subscriber_error_to_delete
            Log.e(TAG, ex.toString())
        }
    }

    sealed class SubscriberState {
        object Inserted: SubscriberState()
        object Update: SubscriberState()
        object Deleted: SubscriberState()
    }

    companion object {
        private val TAG = SubscriberViewModel::class.java.simpleName
    }

}
package com.example.mysubscribers.di

import com.example.mysubscribers.data.db.AppDatabase
import com.example.mysubscribers.repository.SubscriberDataRepository
import com.example.mysubscribers.ui.subscriber.SubscriberViewModel
import com.example.mysubscribers.ui.subscriberslist.SubscriberListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val daoModules = module {
    single { AppDatabase.getInstance(androidContext()).subscriberDao() }
}

val repositoryModules = module {
    single { SubscriberDataRepository(get()) }
}

val viewModules = module {
    viewModel { SubscriberViewModel(get()) }
    viewModel { SubscriberListViewModel(get()) }
}

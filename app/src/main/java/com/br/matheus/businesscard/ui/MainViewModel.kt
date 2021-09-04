package com.br.matheus.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.matheus.businesscard.data.BusinessCard
import com.br.matheus.businesscard.data.BusinessCardRepository

class MainViewModel (private val businessCardRepository: BusinessCardRepository): ViewModel() {
    fun insert(businessCard: BusinessCard){
        businessCardRepository.insert(businessCard)
    }

    fun getAll(): LiveData<List<BusinessCard>> {
        return businessCardRepository.getAll()
    }

    fun update(businessCard: BusinessCard){
        businessCardRepository.update(businessCard)
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
package com.br.matheus.businesscard.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface BusinessCardDao {

    @Query ("SELECT * FROM BusinessCard")
    fun getAll():LiveData<List<BusinessCard>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(businessCard: BusinessCard)

    @Update
    suspend fun update(businessCard: BusinessCard)
}
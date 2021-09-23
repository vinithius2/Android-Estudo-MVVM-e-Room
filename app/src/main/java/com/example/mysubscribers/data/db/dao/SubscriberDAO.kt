package com.example.mysubscribers.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.mysubscribers.data.db.entity.SubscriberEntity

@Dao
interface SubscriberDao {

    @Insert
    suspend fun insert(subsicriber: SubscriberEntity): Long

    @Update
    suspend fun update(subsicriber: SubscriberEntity)

    @Query("DELETE FROM subscriber WHERE id =:id")
    suspend fun delete(id: Long)

    @Query("DELETE FROM subscriber")
    suspend fun deleteAll()

    @Query("SELECT * FROM subscriber")
    suspend fun getAll(): List<SubscriberEntity>

}
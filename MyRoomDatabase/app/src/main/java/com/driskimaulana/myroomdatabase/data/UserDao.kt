package com.driskimaulana.myroomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.driskimaulana.myroomdatabase.model.User

@Dao
interface UserDao {

    /**
     * Insert data to database function
     * OnConflictStrategy.IGNORE mean that if there is a new data inserted same as data that
     * already in database, kotlin will ignore that
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUser()

    /**
     * Function to get all data from database
     * using SQL query
     */
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

}
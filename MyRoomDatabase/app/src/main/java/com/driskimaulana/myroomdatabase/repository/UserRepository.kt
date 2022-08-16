package com.driskimaulana.myroomdatabase.repository

import androidx.lifecycle.LiveData
import com.driskimaulana.myroomdatabase.data.UserDao
import com.driskimaulana.myroomdatabase.model.User

class UserRepository(private val userDao: UserDao) {
    /**
     * This class will access to multiple data sources
     * It's a recommended practice in the Room Library
     */

    val readAllData: LiveData<List<User>>
        get() = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }

    suspend fun deleteAllUser(){
        userDao.deleteAllUser()
    }

}
package com.driskimaulana.myroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.driskimaulana.myroomdatabase.data.UserDatabase
import com.driskimaulana.myroomdatabase.model.User
import com.driskimaulana.myroomdatabase.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * ViewModel is a layer that connect the UI to Database
     */

    var readAllData: LiveData<List<User>>

    private var repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
//        readAllData = userDao.readAllData()
    }

    suspend fun addUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addUser(user)
        }
    }

    suspend fun updateUser(user: User)
    {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }

    suspend fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    suspend fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllUser()
        }
    }

}
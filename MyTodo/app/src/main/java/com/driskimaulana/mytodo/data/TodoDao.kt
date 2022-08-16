package com.driskimaulana.mytodo.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.driskimaulana.mytodo.model.Todo

@Dao
interface TodoDao {

    @Insert
    suspend fun addTodo(todo: Todo)

    @Update
    suspend fun todoCompleted(todo: Todo)

    @Query("SELECT * FROM todo_table ORDER BY status ASC")
    fun readAllTodo(): LiveData<List<Todo>>

}
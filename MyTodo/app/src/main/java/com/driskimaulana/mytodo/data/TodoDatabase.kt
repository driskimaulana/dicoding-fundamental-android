package com.driskimaulana.mytodo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.driskimaulana.mytodo.model.Todo

@Database(entities = [Todo::class], version = 1, exportSchema = true)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

    companion object{

        /**
         * TodoDatabase class singleton
         */
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase{

            val tempInstance = INSTANCE

            if(tempInstance == null){
                synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TodoDatabase::class.java,
                        "todo_database"
                    ).build()

                    instance.let { it -> INSTANCE = it }

                    return instance
                }
            }

            return tempInstance

        }

    }

}
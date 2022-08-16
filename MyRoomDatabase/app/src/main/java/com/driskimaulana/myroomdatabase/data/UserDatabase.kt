package com.driskimaulana.myroomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.driskimaulana.myroomdatabase.model.User
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        /**
         * Create UserDatabase class as Singleton
         * Volatile meaning that changes that made to INSTANCE field
         * will noticeable in every thread that exist
         */
        @Volatile
        private var INSTANCE: UserDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): UserDatabase {
            val tempInstace = INSTANCE

            if (tempInstace == null) {
                synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "user_database"
                    ).build()

                    INSTANCE = instance
                    return instance
                }
            }

            return tempInstace
        }
    }

}
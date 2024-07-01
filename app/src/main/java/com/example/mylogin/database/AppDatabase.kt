package com.example.mylogin.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mylogin.dao.TripDao
import com.example.mylogin.dao.UserDao
import com.example.mylogin.models.Trip
import com.example.mylogin.models.User

@Database(entities = [User::class, Trip::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val tripDao: TripDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context, AppDatabase::class.java, "my-db"
            ).build()
            INSTANCE = instance
            instance
        }
    }

}

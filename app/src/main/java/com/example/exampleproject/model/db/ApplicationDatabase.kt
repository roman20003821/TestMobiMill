package com.example.exampleproject.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.exampleproject.model.MapEntity
import com.example.exampleproject.model.db.converters.ImageDTOListConverter

@Database(entities = arrayOf(MapEntity::class), version = 2)
@TypeConverters(ImageDTOListConverter::class)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun mapEntityDao(): MapEntityDao

    companion object {

        private var sApplicationDatabase: ApplicationDatabase? = null
        private val DB_NAME = "APPLICATION_DB"

        fun instance(context: Context): ApplicationDatabase {
            if (sApplicationDatabase == null) {
                sApplicationDatabase = createDbInstance(context)
            }
            return sApplicationDatabase!!
        }

        private fun createDbInstance(context: Context): ApplicationDatabase {
            synchronized(this){
                val db = Room.databaseBuilder(
                    context,
                    ApplicationDatabase::class.java, DB_NAME
                ).fallbackToDestructiveMigration().build()
                return db
            }
        }
    }
}
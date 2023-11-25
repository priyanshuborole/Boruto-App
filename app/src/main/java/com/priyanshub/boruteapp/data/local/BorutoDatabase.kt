package com.priyanshub.boruteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.priyanshub.boruteapp.data.local.dao.HeroDao
import com.priyanshub.boruteapp.data.local.dao.HeroRemoteKeysDao
import com.priyanshub.boruteapp.domain.model.Hero
import com.priyanshub.boruteapp.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1, exportSchema = false)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao

    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}
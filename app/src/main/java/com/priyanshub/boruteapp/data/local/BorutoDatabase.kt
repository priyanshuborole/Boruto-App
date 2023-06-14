package com.priyanshub.boruteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.priyanshub.boruteapp.data.local.dao.HeroDao
import com.priyanshub.boruteapp.domain.model.Hero

@Database(entities = [Hero::class], version = 1)
abstract class BorutoDatabase: RoomDatabase() {
    abstract fun heroDao(): HeroDao
}
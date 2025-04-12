package com.example.lifesync.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""
            CREATE TABLE IF NOT EXISTS `password` (
                `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                `site_name` TEXT NOT NULL,
                `username` TEXT NOT NULL,
                `password` TEXT NOT NULL
            )
        """)
    }
}
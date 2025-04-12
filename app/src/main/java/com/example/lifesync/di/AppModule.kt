package com.example.lifesync.di // Correct package!

import android.content.Context
import androidx.room.Room
import com.example.lifesync.db.AppDatabase
import com.example.lifesync.db.MIGRATION_1_2
import com.example.lifesync.db.TaskDao
import com.example.lifesync.util.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "lifesync_database"
        ).addMigrations(MIGRATION_1_2).build()
    }

    @Provides
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
        return appDatabase.taskDao()
    }

    @Provides
    fun providePasswordDao(appDatabase: AppDatabase): com.example.lifesync.db.PasswordDao {
        return appDatabase.passwordDao()
    }

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://manage-daily.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }


}
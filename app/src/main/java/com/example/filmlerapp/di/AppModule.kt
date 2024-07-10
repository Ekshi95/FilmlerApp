package com.example.filmlerapp.di

import com.example.filmlerapp.data.datasource.FilmlerDataSource
import com.example.filmlerapp.data.repo.FilmlerRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.firestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideFilmlerDataSource(collectionFilmler:CollectionReference):FilmlerDataSource{
        return FilmlerDataSource(collectionFilmler)
    }

    @Provides
    @Singleton
    fun provideFilmlerRepository(fds:FilmlerDataSource):FilmlerRepository{
        return FilmlerRepository(fds)
    }

    @Provides
    @Singleton
    fun provideCollectionReference():CollectionReference{
        return Firebase.firestore.collection("Filmler")
    }
}
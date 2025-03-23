package data.di

import com.example.data.PokemonApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideApiService(retrofitAdapter: Retrofit): PokemonApiService {
        return retrofitAdapter.create(PokemonApiService::class.java)
    }
}
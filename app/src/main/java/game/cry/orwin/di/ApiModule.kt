package homo.cashwin.online.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import game.cry.orwin.data.ApiServer
import game.cry.orwin.data.URL_SERVER
import javax.inject.Singleton
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApiServer(): ApiServer {
        return Builder()
            .baseUrl(URL_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServer::class.java)
    }
}
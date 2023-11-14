package homo.cashwin.online.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import game.cry.orwin.data.RepositoryServerImpl
import game.cry.orwin.domain.RepositoryServer
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class DiModule {


    @Binds
    @Singleton
    abstract fun bindRepositoryServer(repository: RepositoryServerImpl): RepositoryServer

}
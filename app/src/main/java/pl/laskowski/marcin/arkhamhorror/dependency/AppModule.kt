package pl.laskowski.marcin.arkhamhorror.dependency

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

@Module
class AppModule(private val app: Application) {

    @Provides
    fun provideContext(): Context {
        return app
    }

}
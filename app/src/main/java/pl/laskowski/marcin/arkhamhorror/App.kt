package pl.laskowski.marcin.arkhamhorror

import android.app.Application
import android.content.Context
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.dependency.AppModule
import pl.laskowski.marcin.arkhamhorror.dependency.BackendModule
import pl.laskowski.marcin.arkhamhorror.dependency.DaggerAppComponent

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class App : Application() {

    var component: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        initComponent()
    }

    private fun initComponent() {
        if (component == null) {
            component = DaggerAppComponent.builder()
                    .appModule(AppModule(this))
                    .backendModule(BackendModule(BuildConfig.BACKEND_URL))
                    .build()
        }
    }

}

fun Context.component(): AppComponent {
    return (applicationContext as App).component!!
}

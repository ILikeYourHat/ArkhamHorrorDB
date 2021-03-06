package pl.laskowski.marcin.arkhamhorror.ui.framework

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.dependency.DaggerAppComponent
import pl.laskowski.marcin.arkhamhorror.ui.navigation.ActivityRouter

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

abstract class BaseActivity<out Presenter : BasePresenter<BaseUi>>(
        @LayoutRes private val layoutRes: Int
) : AppCompatActivity(), BaseUi {

    protected val presenter: Presenter by lazy {
        val component = DaggerAppComponent.create()
        val router = ActivityRouter(this)
        providePresenter(router, component)
    }

    abstract fun providePresenter(router: ActivityRouter, component: AppComponent): Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setUpLayout()
        presenter.onCreate()
    }

    private fun setUpLayout() {
        setContentView(layoutRes)
        onLayoutReady()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

}


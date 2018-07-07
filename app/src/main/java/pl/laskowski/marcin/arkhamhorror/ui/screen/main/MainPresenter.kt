package pl.laskowski.marcin.arkhamhorror.ui.screen.main

import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import pl.laskowski.marcin.arkhamhorror.ui.framework.BasePresenter
import pl.laskowski.marcin.arkhamhorror.ui.navigation.Router

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class MainPresenter(ui: MainUi, router: Router, component: AppComponent)
    : BasePresenter<MainUi>(ui, router, component) {

    private val api = component.repository()

    override fun onCreate() {
        super.onCreate()
        execute(api.getAllPacks(), ui::onPacksReady)
    }

    fun onPackClicked(pack: Pack) {
        router.navigateToPackActivity(pack)
    }

}
package pl.laskowski.marcin.arkhamhorror.ui.framework

import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.ui.navigation.Router

abstract class BasePresenter<out Ui : BaseUi>(
        protected val ui: Ui,
        protected val router: Router,
        private val component : AppComponent
) {

    open fun onCreate() {}

    open fun onResume() {}

    open fun onPause() {}

    open fun onDestroy() {}

}
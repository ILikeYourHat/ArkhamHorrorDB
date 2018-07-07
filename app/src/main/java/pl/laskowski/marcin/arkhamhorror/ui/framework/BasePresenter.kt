package pl.laskowski.marcin.arkhamhorror.ui.framework

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.ui.navigation.Router

abstract class BasePresenter<out Ui : BaseUi>(
        protected val ui: Ui,
        protected val router: Router,
        private val component: AppComponent
) {

    lateinit var disposables: CompositeDisposable

    open fun onCreate() {
        disposables = CompositeDisposable()
    }

    open fun onResume() {}

    open fun onPause() {}

    open fun onDestroy() {
        disposables.dispose()
    }

    protected fun <T> execute(single: Single<T>, onSuccess: (t: T) -> Unit) {
        disposables.add(
                single.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(onSuccess, this::onError)
        )
    }

    private fun onError(e: Throwable) {
        when (e) {
            is Error -> throw e
            else -> ui.showExceptionMessage(e.message ?: e::class.java.simpleName)
        }
    }

}
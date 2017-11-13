package pl.laskowski.marcin.arkhamhorror.ui.screen.pack

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import pl.laskowski.marcin.arkhamhorror.ui.framework.BasePresenter
import pl.laskowski.marcin.arkhamhorror.ui.navigation.Router

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackPresenter(ui: PackUi, router: Router, component: AppComponent)
    : BasePresenter<PackUi>(ui, router, component) {

    private val api = component.repository()
    lateinit var pack: Pack

    override fun onResume() {
        super.onResume()
        syncCards()
    }

    private fun syncCards() {
        api.getCardsFromPack(pack)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ cards -> ui.onCardsReady(cards) })
    }

    fun onCardClicked(card: Card) {
        router.navigateToCardDetails(card)
    }

}
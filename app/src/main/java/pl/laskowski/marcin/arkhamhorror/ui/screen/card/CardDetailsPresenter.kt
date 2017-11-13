package pl.laskowski.marcin.arkhamhorror.ui.screen.card

import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.ui.framework.BasePresenter
import pl.laskowski.marcin.arkhamhorror.ui.navigation.Router

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class CardDetailsPresenter(ui: CardDetailsUi, router: Router, component: AppComponent)
    : BasePresenter<CardDetailsUi>(ui, router, component) {

    lateinit var card: Card

    override fun onResume() {
        super.onResume()
        updateCard()
    }

    private fun updateCard() {
        ui.setTitle(card.name)
        ui.setSubtitle(card.subname)
        ui.setImage(card.imageUrl)
        ui.setDescription(card.description)
    }

}
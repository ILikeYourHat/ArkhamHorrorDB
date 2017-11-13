package pl.laskowski.marcin.arkhamhorror.ui.navigation

import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
interface Router {

    fun navigateToCardDetails(card: Card)

    fun navigateToPackActivity(pack: Pack)
}
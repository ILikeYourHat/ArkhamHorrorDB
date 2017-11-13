package pl.laskowski.marcin.arkhamhorror.ui.screen.pack

import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseUi

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

interface PackUi : BaseUi {
    fun onCardsReady(cards: List<Card>)
}
package pl.laskowski.marcin.arkhamhorror.ui.navigation

import android.content.Intent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

private const val packKey = "pack"
private const val cardKey = "card"

fun Intent.getPack(): Pack {
    return this.getSerializableExtra(packKey) as Pack
}

fun Intent.putPack(pack: Pack) {
    this.putExtra(packKey, pack)
}

fun Intent.getCard(): Card {
    return this.getSerializableExtra(cardKey) as Card
}

fun Intent.putCard(card: Card) {
    this.putExtra(cardKey, card)
}
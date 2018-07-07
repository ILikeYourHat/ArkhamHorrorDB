package pl.laskowski.marcin.arkhamhorror.ui.navigation

import android.content.Intent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

private const val KEY_PACK = "pack"
private const val KEY_CARD = "card"

fun Intent.getPack(): Pack {
    return this.getSerializableExtra(KEY_PACK) as Pack
}

fun Intent.putPack(pack: Pack) {
    this.putExtra(KEY_PACK, pack)
}

fun Intent.getCard(): Card {
    return this.getSerializableExtra(KEY_CARD) as Card
}

fun Intent.putCard(card: Card) {
    this.putExtra(KEY_CARD, card)
}
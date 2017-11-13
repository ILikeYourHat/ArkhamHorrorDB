package pl.laskowski.marcin.arkhamhorror.ui.navigation

import android.app.Activity
import android.content.Intent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import pl.laskowski.marcin.arkhamhorror.ui.screen.card.CardDetailsActivity
import pl.laskowski.marcin.arkhamhorror.ui.screen.pack.PackActivity

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
class ActivityRouter(private val activity: Activity) : Router {

    override fun navigateToPackActivity(pack: Pack) {
        val intent = Intent(activity, PackActivity::class.java)
        intent.putPack(pack)
        activity.startActivity(intent)
    }

    override fun navigateToCardDetails(card: Card) {
        val intent = Intent(activity, CardDetailsActivity::class.java)
        intent.putCard(card)
        activity.startActivity(intent)
    }

}
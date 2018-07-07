package pl.laskowski.marcin.arkhamhorror.ui.screen.card

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_card.*
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseActivity
import pl.laskowski.marcin.arkhamhorror.ui.navigation.ActivityRouter
import pl.laskowski.marcin.arkhamhorror.ui.navigation.getCard


/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class CardDetailsActivity : CardDetailsUi, BaseActivity<CardDetailsPresenter>(
        layoutRes = R.layout.activity_card
) {

    override fun providePresenter(router: ActivityRouter, component: AppComponent): CardDetailsPresenter {
        return CardDetailsPresenter(this, router, component)
                .apply { card = intent.getCard() }
    }

    override fun setTitle(title: String) {
        vToolbar.title = title
    }

    override fun setImage(imageUrl: String?) {
        Picasso.get()
                .load(imageUrl)
                .into(ivCard)
    }

    override fun setSubtitle(subtitle: String?) {
        vToolbar.subtitle = subtitle
    }

    override fun setDescription(description: String) {
        tvDescription.richText = description
    }

}
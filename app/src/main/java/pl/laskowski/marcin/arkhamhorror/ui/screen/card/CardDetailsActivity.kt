package pl.laskowski.marcin.arkhamhorror.ui.screen.card

import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotterknife.bindView
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

    private val vToolbar: Toolbar by bindView(R.id.vToolbar)
    private val ivCard: ImageView by bindView(R.id.ivCard)
    private val tvDescription: TextView by bindView(R.id.tvDescription)

    override fun providePresenter(router: ActivityRouter, component: AppComponent): CardDetailsPresenter {
        return CardDetailsPresenter(this, router, component)
                .apply { card = intent.getCard() }
    }

    override fun setTitle(title: String) {
        vToolbar.title = title
    }

    override fun setImage(imageUrl: String?) {
        Picasso.with(this)
                .load(imageUrl)
                .into(ivCard)
    }

    override fun setSubtitle(subtitle: String?) {
        vToolbar.subtitle = subtitle
    }

    override fun setDescription(description: String) {
        tvDescription.text = description
    }

}
package pl.laskowski.marcin.arkhamhorror.ui.screen.pack

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotterknife.bindView
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.ui.adapter.card.CardAdapter
import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseActivity
import pl.laskowski.marcin.arkhamhorror.ui.navigation.ActivityRouter
import pl.laskowski.marcin.arkhamhorror.ui.navigation.getPack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackActivity : PackUi, BaseActivity<PackPresenter>(
        layoutRes = R.layout.activity_pack
) {

    override fun providePresenter(router: ActivityRouter, component: AppComponent): PackPresenter {
        return PackPresenter(this, router, component)
                .apply { pack = intent.getPack() }
    }

    private val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    private val cardAdapter = CardAdapter(this, { presenter.onCardClicked(it) })

    override fun onLayoutReady() {
        recyclerView.apply {
            adapter = cardAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onCardsReady(cards: List<Card>) {
        cardAdapter.update(cards)
    }

}
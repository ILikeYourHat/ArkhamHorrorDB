package pl.laskowski.marcin.arkhamhorror.ui.screen.main

import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotterknife.bindView
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.dependency.AppComponent
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import pl.laskowski.marcin.arkhamhorror.ui.adapter.pack.PackAdapter
import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseActivity
import pl.laskowski.marcin.arkhamhorror.ui.navigation.ActivityRouter


/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class MainActivity : MainUi, BaseActivity<MainPresenter>(
        layoutRes = R.layout.activity_main
) {

    override fun providePresenter(router: ActivityRouter, component: AppComponent): MainPresenter {
        return MainPresenter(this, router, component)
    }

    private val recyclerView: RecyclerView by bindView(R.id.recyclerView)

    private val packAdapter = PackAdapter(this, { presenter.onPackClicked(it) })

    override fun onLayoutReady() {
        recyclerView.apply {
            adapter = packAdapter
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }
    }

    override fun onPacksReady(packs: List<Pack>) {
        packAdapter.update(packs)
    }

}
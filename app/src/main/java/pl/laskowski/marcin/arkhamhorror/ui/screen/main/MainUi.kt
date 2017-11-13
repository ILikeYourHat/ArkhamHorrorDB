package pl.laskowski.marcin.arkhamhorror.ui.screen.main

import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseUi

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

interface MainUi : BaseUi {
    fun onPacksReady(packs: List<Pack>)
}
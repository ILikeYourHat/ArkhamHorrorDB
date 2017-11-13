package pl.laskowski.marcin.arkhamhorror.ui.screen.card

import pl.laskowski.marcin.arkhamhorror.ui.framework.BaseUi

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
interface CardDetailsUi : BaseUi {
    fun setTitle(title: String)
    fun setImage(imageUrl: String?)
    fun setSubtitle(subtitle: String?)
    fun setDescription(description: String)
}
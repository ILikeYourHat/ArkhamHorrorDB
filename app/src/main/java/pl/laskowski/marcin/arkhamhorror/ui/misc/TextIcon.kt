package pl.laskowski.marcin.arkhamhorror.ui.misc

import android.support.annotation.DrawableRes
import pl.laskowski.marcin.arkhamhorror.R

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

enum class TextIcon(val phase: String, @DrawableRes val drawable: Int) {
    FREE("[free]", R.drawable.ic_symbol_free),
    ACTION("[action]", R.drawable.ic_symbol_action),
    REACTION("[reaction]", R.drawable.ic_symbol_reaction),
    ELDER_SIGN("[elder_sign]", R.drawable.ic_symbol_elder_sign),
    COMBAT("[combat]", R.drawable.ic_symbol_combat),
    SURVIVOR("[survivor]", R.drawable.ic_symbol_survivor)
}
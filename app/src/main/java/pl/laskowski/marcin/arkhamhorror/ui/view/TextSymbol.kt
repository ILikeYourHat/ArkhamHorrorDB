package pl.laskowski.marcin.arkhamhorror.ui.view

import android.support.annotation.DrawableRes
import pl.laskowski.marcin.arkhamhorror.R

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

enum class TextSymbol(val phase: String, @DrawableRes val drawable: Int) {

    // ACTIONS
    FREE("[free]", R.drawable.ic_symbol_free),
    ACTION("[action]", R.drawable.ic_symbol_action),
    REACTION("[reaction]", R.drawable.ic_symbol_reaction),
    LIGHTING("[lightning]", R.drawable.ic_symbol_lightning),

    // CLASSES
    SURVIVOR("[survivor]", R.drawable.ic_symbol_survivor),
    GUARDIAN("[guardian]", R.drawable.ic_symbol_guardian),
    SEEKER("[seeker]", R.drawable.ic_symbol_seeker),
    ROGUE("[rogue]", R.drawable.ic_symbol_rogue),
    MYSTIC("[mystic]", R.drawable.ic_symbol_mystic),

    // STATS
    AGILITY("[agility]", R.drawable.ic_symbol_agility),
    INTELLECT("[intellect]", R.drawable.ic_symbol_intellect),
    COMBAT("[combat]", R.drawable.ic_symbol_combat),
    WILLPOWER("[willpower]", R.drawable.ic_symbol_willpower),
    WILD("[wild]", R.drawable.ic_symbol_wild),

    // TOKENS
    ELDER_SIGN("[elder_sign]", R.drawable.ic_symbol_elder_sign),
    SKULL("[skull]", R.drawable.ic_symbol_skull),
    CULTIST("[cultist]", R.drawable.ic_symbol_cultist),
    TABLET("[tablet]", R.drawable.ic_symbol_tablet),
    ELDER_THING("[elder_thing]", R.drawable.ic_symbol_elder_thing),
    AUTO_FAIL("[auto_fail]", R.drawable.ic_symbol_auto_fail),

}
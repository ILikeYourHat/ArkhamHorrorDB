package pl.laskowski.marcin.arkhamhorror.util

import android.text.Html
import android.text.Spanned

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

fun fromHtml(source: String): Spanned {
    if (isNougatOrAbove()) {
        return Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(source)
    }
}
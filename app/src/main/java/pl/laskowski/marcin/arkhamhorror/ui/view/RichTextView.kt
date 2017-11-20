package pl.laskowski.marcin.arkhamhorror.ui.view

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.util.AttributeSet
import pl.laskowski.marcin.arkhamhorror.ui.misc.CenteredImageSpan
import pl.laskowski.marcin.arkhamhorror.util.fromHtml

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
class RichTextView : AppCompatTextView {

    var richText: String = ""
        set(value) {
            field = value
            text = fromHtml(value).addIcons()
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun Spanned.addIcons(): Spanned {
        val builder = SpannableStringBuilder(this)

        var index: Int
        for (symbol in TextSymbol.values()) {
            val phase = symbol.phase
            index = indexOf(phase)
            while (index >= 0) {
                val icon = CenteredImageSpan(context, symbol.drawable)
                builder.setSpan(icon, index, index + phase.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                index = indexOf(phase, index + 1)
            }
        }
        return builder
    }

}
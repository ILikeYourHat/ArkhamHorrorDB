package pl.laskowski.marcin.arkhamhorror.ui.view

import android.content.Context
import android.os.Build
import android.support.v7.widget.AppCompatTextView
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.util.AttributeSet
import pl.laskowski.marcin.arkhamhorror.ui.misc.CenteredImageSpan
import pl.laskowski.marcin.arkhamhorror.ui.misc.TextIcon

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
class RichTextView : AppCompatTextView {

    var richText: String = ""
        set(value) {
            field = value
            text = getFromHtml(value).addIcons()
        }

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun getFromHtml(description: String): Spanned {
        val fixedDescription = description.replace("\n", "<br/>")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(fixedDescription, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            return Html.fromHtml(fixedDescription)
        }
    }

    private fun Spanned.addIcons(): Spanned {
        var index: Int
        val builder = SpannableStringBuilder()
        builder.append(this)

        for (entry in TextIcon.values()) {
            index = this.indexOf(entry.phase)
            while (index >= 0) {
                val span = CenteredImageSpan(context, entry.drawable)
                builder.setSpan(span, index, index + entry.phase.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                index = this.indexOf(entry.phase, index + 1)
            }

        }
        return builder
    }

}
package pl.laskowski.marcin.arkhamhorror.ui.misc

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.style.ImageSpan
import java.lang.ref.WeakReference


/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class CenteredImageSpan(context: Context, drawableRes: Int) : ImageSpan(context, drawableRes) {

    private var drawableRef: WeakReference<Drawable>? = null

    // Redefined locally because it is a private member from DynamicDrawableSpan
    private val cachedDrawable: Drawable
        get() {
            val current: Drawable? = drawableRef?.get()
            return if (current == null) {
                drawableRef = WeakReference(drawable)
                drawable
            } else {
                current
            }
        }

    override fun getSize(paint: Paint, text: CharSequence,
                         start: Int, end: Int,
                         fm: Paint.FontMetricsInt?): Int {
        val d = cachedDrawable
        val rect = d.bounds

        if (fm != null) {
            val pfm = paint.fontMetricsInt
            // keep it the same as paint's fm
            fm.ascent = pfm.ascent
            fm.descent = pfm.descent
            fm.top = pfm.top
            fm.bottom = pfm.bottom
        }

        return rect.right
    }

    override fun draw(canvas: Canvas, text: CharSequence,
                      start: Int, end: Int, x: Float,
                      top: Int, y: Int, bottom: Int, paint: Paint) {
        val b = cachedDrawable
        canvas.save()

        val drawableHeight = b.intrinsicHeight
        val fontAscent = paint.fontMetricsInt.ascent
        val fontDescent = paint.fontMetricsInt.descent
        val transY = bottom - b.bounds.bottom +  // align bottom to bottom
                (drawableHeight - fontDescent + fontAscent) / 2  // align center to center

        canvas.translate(x, transY.toFloat())
        b.draw(canvas)
        canvas.restore()
    }

}
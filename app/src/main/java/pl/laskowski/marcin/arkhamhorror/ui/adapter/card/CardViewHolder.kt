package pl.laskowski.marcin.arkhamhorror.ui.adapter.card

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotterknife.bindView
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.model.card.Card

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val context = itemView.context
    private val textView: TextView by bindView(R.id.text)
    private val imageView: ImageView by bindView(R.id.image)

    fun bind(card: Card, listener: (Card) -> Any) {
        itemView.setOnClickListener({ listener.invoke(card) })
        textView.text = card.name
        Picasso.with(context)
                .load(card.imageUrl)
                .into(imageView)
    }

}
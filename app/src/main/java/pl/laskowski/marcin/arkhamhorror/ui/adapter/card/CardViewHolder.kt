package pl.laskowski.marcin.arkhamhorror.ui.adapter.card

import android.support.v7.widget.RecyclerView
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_card.view.*
import pl.laskowski.marcin.arkhamhorror.model.card.Card

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(card: Card, listener: (Card) -> Any) {
        itemView.setOnClickListener { listener.invoke(card) }
        itemView.text.text = card.name
        Picasso.get()
                .load(card.imageUrl)
                .into(itemView.image)
    }

}
package pl.laskowski.marcin.arkhamhorror.ui.adapter.card

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.model.card.Card


/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class CardAdapter(context: Context, private var listener: (Card) -> Unit)
    : RecyclerView.Adapter<CardViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private var cards: List<Card> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = inflater.inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card, listener)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun update(cards: List<Card>) {
        this.cards = cards
        notifyDataSetChanged()
    }

}
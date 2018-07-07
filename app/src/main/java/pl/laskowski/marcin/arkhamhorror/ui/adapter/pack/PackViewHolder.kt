package pl.laskowski.marcin.arkhamhorror.ui.adapter.pack

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.item_pack.view.*
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(pack: Pack, listener: (Pack) -> Unit) {
        itemView.setOnClickListener { listener.invoke(pack) }
        itemView.tvName.text = pack.name
        itemView.tvCount.text = "${pack.cardsKnown}/${pack.cardsTotal}"
    }

}
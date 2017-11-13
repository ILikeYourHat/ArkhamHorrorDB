package pl.laskowski.marcin.arkhamhorror.ui.adapter.pack

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotterknife.bindView
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvName: TextView by bindView(R.id.tvName)
    private val tvCount: TextView by bindView(R.id.tvCount)

    fun bind(pack: Pack, listener: (Pack) -> Unit) {
        itemView.setOnClickListener { listener.invoke(pack) }
        tvName.text = pack.name
        tvCount.text = "${pack.cardsKnown}/${pack.cardsTotal}"
    }

}
package pl.laskowski.marcin.arkhamhorror.ui.adapter.pack

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import pl.laskowski.marcin.arkhamhorror.R
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackAdapter(context: Context, private var listener: (Pack) -> Unit)
    : RecyclerView.Adapter<PackViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private var packs: List<Pack> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackViewHolder {
        val view = inflater.inflate(R.layout.item_pack, parent, false)
        return PackViewHolder(view)
    }

    override fun onBindViewHolder(holder: PackViewHolder, position: Int) {
        val pack = packs[position]
        holder.bind(pack, listener)
    }

    override fun getItemCount(): Int {
        return packs.size
    }

    fun update(packs: List<Pack>) {
        this.packs = packs
        notifyDataSetChanged()
    }

}
package pl.laskowski.marcin.arkhamhorror.model.card

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
data class AssetCard(
        override val id: String,
        override val name: String,
        override val subname: String?,
        override val imageUrl: String?,
        override val description: String,
        override val faction: Faction,
        override val packId: String,
        val slot: Slot
) : ICard
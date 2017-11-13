package pl.laskowski.marcin.arkhamhorror.model.card

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
interface ICard {
    val id: String
    val name: String
    val subname: String?
    val imageUrl: String?
    val description: String
    val faction: Faction
    val packId: String
}
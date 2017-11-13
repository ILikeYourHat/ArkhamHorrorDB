package pl.laskowski.marcin.arkhamhorror.model.pack

import java.io.Serializable

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
data class Pack(
        val id: String,
        val name: String,
        val cardsKnown: Int,
        val cardsTotal: Int,
        val cycle: Int,
        val positionInCycle: Int
) : Serializable
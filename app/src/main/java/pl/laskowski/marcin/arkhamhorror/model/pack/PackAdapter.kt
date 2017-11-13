package pl.laskowski.marcin.arkhamhorror.model.pack

import com.squareup.moshi.FromJson

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class PackAdapter {

    @FromJson
    fun fromJson(json: PackJson): Pack {
        var cycle = json.cycle_position ?: 0
        if (cycle == 80) cycle = 0
        return Pack(
                id = json.code!!,
                name = json.name ?: "",
                cardsKnown = json.known ?: 0,
                cardsTotal = json.total ?: 0,
                cycle = cycle,
                positionInCycle = json.position ?: 0
        )
    }

}
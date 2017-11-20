package pl.laskowski.marcin.arkhamhorror.model.card

import com.squareup.moshi.FromJson


/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class CardAdapter {

    @FromJson
    fun fromJson(json: CardJson): Card {
        val imageUrl = if (json.imagesrc != null) "https://arkhamdb.com" + json.imagesrc else null
        return Card(
                id = json.code!!,
                name = json.name ?: "",
                subname = json.subname,
                imageUrl = imageUrl,
                description = json.text?.toRichText() ?: "",
                faction = factionFromJson(json),
                packId = json.pack_code!!
        )
    }

    private fun factionFromJson(json: CardJson): Faction {
        return when (json.faction_code) {
            "guardian" -> Faction.GUARDIAN
            "mystic" -> Faction.MYSTIC
            "mythos" -> Faction.MYTHOS
            "rogue" -> Faction.ROGUE
            "seeker" -> Faction.SEEKER
            "survivor" -> Faction.SURVIVOR
            "neutral" -> Faction.NEUTRAL
            else -> throw IllegalArgumentException("${json.faction_code} is not a valid faction")
        }
    }


    private fun String.toRichText(): String {
        return fixLineBreaks()
    }

    private fun String.fixLineBreaks(): String {
        return replace("\n", "<br/>")
    }
}
package pl.laskowski.marcin.arkhamhorror.model.card

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
data class CardJson (
        val pack_code: String?,
        val pack_name: String?,
        val type_code: String?,
        val type_name: String?,
        val faction_code: String?,
        val faction_name: String?,
        val position: Int?,
        val exceptional: Boolean?,
        val code: String?,
        val name: String?,
        val subname: String?,
        val text: String?,
        val quantity: Int?,
        val skill_willpower: Int?,
        val skill_intellect: Int?,
        val skill_combat: Int?,
        val skill_agility: Int?,
        val clues_fixed: Boolean?,
        val health: Int?,
        val health_per_investigator: Boolean?,
        val sanity: Int?,
        val deck_limit: Int?,
        val traits: String?,
        val flavor: String?,
        val illustrator: String?,
        val is_unique: Boolean?,
        val deck_requirements: DeckRequirementsJson?,
        val exile: Boolean?,
        val hidden: Boolean?,
        val permanent: Boolean?,
        val double_sided: Boolean?,
        val back_text: String?,
        val back_flavor: String?,
        val octgn_id: String?,
        val imagesrc: String?,
        val backimagesrc: String?,
        val subtype_code: String?,
        val subtype_name: String?,
        val slot: String?
)
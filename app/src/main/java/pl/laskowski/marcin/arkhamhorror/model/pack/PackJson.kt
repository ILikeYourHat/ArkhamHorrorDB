package pl.laskowski.marcin.arkhamhorror.model.pack

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */
data class PackJson(
        val name: String?,
        val code: String?,
        val position: Int?,
        val cycle_position: Int?,
        val available: String?,
        val known: Int?,
        val total: Int?,
        val url: String?,
        val id: Long?
)
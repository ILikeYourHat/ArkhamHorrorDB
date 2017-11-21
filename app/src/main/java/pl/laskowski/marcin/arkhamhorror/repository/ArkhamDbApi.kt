package pl.laskowski.marcin.arkhamhorror.repository

import io.reactivex.Single
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import retrofit2.http.GET

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

interface ArkhamDbApi {

    @GET("api/public/cards")
    fun getCards() : Single<List<Card>>

    @GET("api/public/packs")
    fun getPacks() : Single<List<Pack>>

}
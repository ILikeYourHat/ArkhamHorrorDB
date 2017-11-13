package pl.laskowski.marcin.arkhamhorror.repository

import com.squareup.moshi.Moshi
import io.reactivex.Observable
import io.reactivex.Single
import pl.laskowski.marcin.arkhamhorror.model.card.Card
import pl.laskowski.marcin.arkhamhorror.model.card.CardAdapter
import pl.laskowski.marcin.arkhamhorror.model.pack.Pack
import javax.inject.Inject

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class ApiRepository
@Inject constructor(private val api: ArkhamDbApi, private val moshi: Moshi) {

    private val packComparator = compareByDescending<Pack> { it.cycle }
            .thenByDescending { it.positionInCycle }

    fun getAllPacks(): Single<List<Pack>> {
        return api.getPacks()
                .flatMapObservable { Observable.fromIterable(it) }
                .sorted(packComparator)
                .toList()
    }

    fun getCardsFromPack(pack: Pack): Single<List<Card>> {
        return api.getCards()
                .flatMapObservable { Observable.fromIterable(it) }
                .map { CardAdapter().fromJson(it) }
                .filter { card -> card.packId == pack.id }
                .toList()
    }

}
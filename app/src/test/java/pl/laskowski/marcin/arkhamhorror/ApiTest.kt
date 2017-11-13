package pl.laskowski.marcin.arkhamhorror

import io.reactivex.Observable
import org.junit.Test
import pl.laskowski.marcin.arkhamhorror.dependency.DaggerAppComponent

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

class ApiTest {

    @Test
    fun test() {
        val component = DaggerAppComponent.create()
        val api = component.api()
        api.getCards()
                .flatMapObservable { Observable.fromIterable(it) }
                .filter { it.type_name == "Asset" }
                .filter { it.slot != null }
//                .concatMap { Observable.fromIterable(it.split(".")) }
                .map { it.slot }
                .distinct()
//                .filter { it.isNotBlank() }
                .doOnNext { println(it) }
                .subscribe()

    }

}

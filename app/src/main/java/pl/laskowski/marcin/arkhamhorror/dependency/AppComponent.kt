package pl.laskowski.marcin.arkhamhorror.dependency

import dagger.Component
import pl.laskowski.marcin.arkhamhorror.repository.ApiRepository
import pl.laskowski.marcin.arkhamhorror.repository.ArkhamDbApi
import javax.inject.Singleton

/**
 * Created by Marcin Laskowski.
 * Senfino 2017
 */

@Singleton
@Component(modules = arrayOf(
        BackendModule::class
))
interface AppComponent {

    fun repository(): ApiRepository

    fun api(): ArkhamDbApi

}
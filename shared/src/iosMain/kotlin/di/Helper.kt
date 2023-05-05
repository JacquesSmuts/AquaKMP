@file:Suppress("unused")

package di

import data.WaterRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule())
    }
}

class RepositoryHelper : KoinComponent {
    val waterRepository : WaterRepository by inject()
}
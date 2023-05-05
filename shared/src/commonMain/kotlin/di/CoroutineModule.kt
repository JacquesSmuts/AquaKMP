package di

import kotlinx.coroutines.Dispatchers
import org.koin.core.qualifier.named
import org.koin.dsl.module

val coroutineModule = module {
    single(named(CoroutineModule.IODispatcher)) {
        Dispatchers.Default
    }
}

object CoroutineModule {
    const val IODispatcher = "IODispatcher"
}
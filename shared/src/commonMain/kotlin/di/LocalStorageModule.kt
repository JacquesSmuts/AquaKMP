package di

import database.DatabaseAqua
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val localStorageModule = module {
    singleOf(::Storage)
}

expect class Storage() {
    val ioDispatcher: CoroutineDispatcher
    val database: DatabaseAqua
}
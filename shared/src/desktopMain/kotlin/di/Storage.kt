package di

import database.DatabaseAqua
import kotlinx.coroutines.CoroutineDispatcher

actual class Storage actual constructor() {
    actual val ioDispatcher: CoroutineDispatcher
        get() = TODO("Not yet implemented")
    actual val database: DatabaseAqua
        get() = TODO("Not yet implemented")
}
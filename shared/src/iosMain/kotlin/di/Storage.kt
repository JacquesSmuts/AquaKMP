package di

import database.DatabaseAqua
import database.DriverFactory
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class Storage: KoinComponent {

    actual val ioDispatcher: CoroutineDispatcher by inject()

    actual val database: DatabaseAqua = DatabaseAqua(
        driverFactory = DriverFactory(),
        dispatcher = ioDispatcher
    )
}


package di

import android.content.Context
import database.DatabaseAqua
import database.DriverFactory
import kotlinx.coroutines.CoroutineDispatcher
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.qualifier.named

actual class Storage: KoinComponent {

    actual val ioDispatcher: CoroutineDispatcher by inject(qualifier = named(CoroutineModule.IODispatcher))
    private val context: Context by inject()

    actual val database: DatabaseAqua = DatabaseAqua(
        driverFactory = DriverFactory(context),
        dispatcher = ioDispatcher
    )
}


package database

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.jacquessmuts.aquakmp.Database

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(schema = Database.Schema, name = DatabaseAqua.DatabaseName)
    }
}
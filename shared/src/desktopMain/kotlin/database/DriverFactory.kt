package database

import app.cash.sqldelight.db.SqlDriver

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        TODO("Add Native Sqlite Driver")
//        return NativeSqliteDriver(schema = Database.Schema, name = "aquakmp.db")
    }
}
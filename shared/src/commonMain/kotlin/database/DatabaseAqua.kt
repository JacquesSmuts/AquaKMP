package database

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOne
import co.touchlab.kermit.Logger
import com.jacquessmuts.aquakmp.DailyProgress
import com.jacquessmuts.aquakmp.Database
import com.jacquessmuts.aquakmp.WaterSettings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class DatabaseAqua(
  driverFactory: DriverFactory,
  private val dispatcher: CoroutineDispatcher,
) {
  private val database: Database = Database(driverFactory.createDriver())

  val waterSettingsFlow: Flow<WaterSettings>
    get() = database.waterSettingsQueries.select().asFlow().mapToOne(dispatcher)

  val dailyProgressFlow: Flow<List<DailyProgress>>
    get() = database.dailyProgressQueries.select().asFlow().mapToList(dispatcher)

  fun insertWaterSettings(waterSettings: WaterSettings) {
    Logger.d { "Inserting waterSettings $waterSettings" }
    database.waterSettingsQueries.insert(
      goalPerDayMilliliter = waterSettings.goalPerDayMilliliter,
      portionsPerDay = waterSettings.portionsPerDay,
      dayStartHour = waterSettings.dayStartHour,
      dayStartMinute = waterSettings.dayStartMinute,
      dayEndHour = waterSettings.dayEndHour,
      dayEndMinute = waterSettings.dayEndMinute,
    )
  }

  fun insertDailyProgress(dailyProgress: DailyProgress) {
    Logger.d { "Inserting dailyProgress $dailyProgress" }
    database.dailyProgressQueries.insert(dailyProgress)
  }

  /**
   * This class deletes the database if the data is corrupt or the version is lower than it
   * should be. This is to prevent the app from becoming unusable in case there is a rollback.
   */
//  class DefaultDatabaseCallback(private val appContext: Context) : AndroidSqliteDriver.Callback(Database.Schema) {
//    override fun onCorruption(db: SupportSQLiteDatabase) {
//      Timber.e("Fixing database corruption by wiping database.")
//      appContext.deleteDatabase(DatabaseName)
//      super.onCorruption(db)
//    }
//
//    override fun onDowngrade(db: SupportSQLiteDatabase, oldVersion: Int, newVersion: Int) {
//      Timber.e("Downgrading app database by wiping it.")
//      appContext.deleteDatabase(DatabaseName)
//      super.onDowngrade(db, oldVersion, newVersion)
//    }
//  }

  companion object {
    const val DatabaseName = "aquakmp.db"
  }
}

package data

import com.jacquessmuts.aquakmp.DailyProgress
import com.jacquessmuts.aquakmp.WaterSettings
import database.DatabaseAqua
import di.Storage
import kotlinx.coroutines.flow.Flow

class WaterRepository(private val storage: Storage) {
    val texty: String = "Hello world from Repo"
    val database: DatabaseAqua get() = storage.database
    val waterSettingsFlow: Flow<WaterSettings>
        get() = database.waterSettingsFlow

    val dailyProgressFlow: Flow<List<DailyProgress>>
        get() = database.dailyProgressFlow

    suspend fun updateWaterSettings(waterSettings: WaterSettings) {
        database.insertWaterSettings(waterSettings)
    }

    suspend fun updateDailyProgress(dailyProgress: DailyProgress) {
        database.insertDailyProgress(dailyProgress)
    }
}
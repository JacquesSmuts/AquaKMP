import androidx.compose.runtime.Composable
import data.WaterRepository

actual fun getPlatformName(): String = "Android"

@Composable fun MainView(waterRepository: WaterRepository) = App(waterRepository)

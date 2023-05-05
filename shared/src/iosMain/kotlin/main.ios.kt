import androidx.compose.ui.window.ComposeUIViewController
import data.WaterRepository

actual fun getPlatformName(): String = "iOS"

@Suppress("unused")
fun MainViewController(waterRepository: WaterRepository) = ComposeUIViewController { App(waterRepository) }
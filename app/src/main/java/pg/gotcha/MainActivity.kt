package pg.gotcha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import pg.gotcha.ui.theme.AppTheme
import top.niunaijun.blackbox.BlackBoxCore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        BlackBoxCore.get().onBeforeMainActivityOnCreate(this)
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Text(
                        text = "Hello World!\n" + MyApp.baseDir.absolutePath,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        BlackBoxCore.get().onAfterMainActivityOnCreate(this)
    }
}

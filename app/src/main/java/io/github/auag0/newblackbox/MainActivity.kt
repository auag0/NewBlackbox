package io.github.auag0.newblackbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import io.github.auag0.newblackbox.ui.MainScreen
import io.github.auag0.newblackbox.ui.theme.AppTheme
import top.niunaijun.blackbox.BlackBoxCore

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        BlackBoxCore.get().onBeforeMainActivityOnCreate(this)
        setContent {
            AppTheme {
                MainScreen()
            }
        }
        BlackBoxCore.get().onAfterMainActivityOnCreate(this)
    }
}

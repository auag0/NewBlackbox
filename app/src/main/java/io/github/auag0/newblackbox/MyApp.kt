package io.github.auag0.newblackbox

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import top.niunaijun.blackbox.BlackBoxCore
import top.niunaijun.blackbox.app.configuration.ClientConfiguration

@HiltAndroidApp
class MyApp : Application() {
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        BlackBoxCore.get().closeCodeInit()
        BlackBoxCore.get().onBeforeMainApplicationAttach(this, base)
        BlackBoxCore.get().doAttachBaseContext(this, object : ClientConfiguration() {
            override fun getHostPackageName(): String {
                return base.packageName
            }

            override fun isHideRoot(): Boolean {
                return true
            }

            override fun isHideXposed(): Boolean {
                return true
            }

            override fun isEnableDaemonService(): Boolean {
                return false
            }
        })
        BlackBoxCore.get().onAfterMainApplicationAttach(this, base)
    }

    override fun onCreate() {
        super.onCreate()
        BlackBoxCore.get().doCreate()
    }
}
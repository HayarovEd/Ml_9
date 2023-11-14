package game.cry.orwin

import android.app.Application
import com.appsflyer.AppsFlyerLib
import com.my.tracker.MyTracker
import com.yandex.metrica.YandexMetrica
import com.yandex.metrica.YandexMetricaConfig
import dagger.hilt.android.HiltAndroidApp
import game.cry.orwin.data.APPS_FLYER
import game.cry.orwin.data.APP_METRICA
import game.cry.orwin.data.MY_TRACKER
import game.cry.orwin.data.USER_X
import pro.userx.UserX

@HiltAndroidApp
class Ml9App:Application() {
    override fun onCreate() {
        super.onCreate()

        val config = YandexMetricaConfig.newConfigBuilder(APP_METRICA).build()


        MyTracker.initTracker(MY_TRACKER, this)
        YandexMetrica.activate(applicationContext, config)
        YandexMetrica.enableActivityAutoTracking(this)
        AppsFlyerLib.getInstance().init(APPS_FLYER, null, this)
        AppsFlyerLib.getInstance().start(this)
        UserX.init(USER_X)
    }
}
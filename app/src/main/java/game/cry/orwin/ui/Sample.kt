package game.cry.orwin.ui

import android.content.pm.ActivityInfo
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import game.cry.orwin.domain.model.StatusApplication.Loading
import game.cry.orwin.domain.model.StatusApplication.NoConnect
import game.cry.orwin.domain.model.StatusApplication.Web

@Composable
fun Sample(
    activity: ComponentActivity,
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    when (val currentState = state.value.statusApplication) {
        Loading -> LoadingScreen()
        NoConnect -> {
            NoConnectScreen()
        }

        is Web -> {
            if (currentState.stateOrientation !is StateOrientation.Auto)
            SetScreenOrientation(
                activity = activity,
                stateOrientation = currentState.stateOrientation
            )
            WebViewScreen(url = currentState.url)
        }
    }
}

@Composable
fun SetScreenOrientation(
    activity: ComponentActivity,
    stateOrientation: StateOrientation) {
    when (stateOrientation) {
        StateOrientation.Vertical  -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        StateOrientation.Horizontal -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        else -> activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    }
   /* if (orientation=="1") {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    } else {
        activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    }*/
}
package game.cry.orwin.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import game.cry.orwin.domain.model.StatusApplication.Loading
import game.cry.orwin.domain.model.StatusApplication.NoConnect
import game.cry.orwin.domain.model.StatusApplication.Web

@Composable
fun Sample(
    viewModel: MainViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState()
    when (val currentState = state.value.statusApplication) {
        Loading -> LoadingScreen()
        NoConnect -> {
            NoConnectScreen()
        }

        is Web -> {
            WebViewScreen(url = currentState.url)
        }
    }
}
package game.cry.orwin.domain.model

import game.cry.orwin.ui.StateOrientation

sealed class StatusApplication {
    object Loading: StatusApplication()
    object NoConnect : StatusApplication()

    class Web (
        val url: String,
        val stateOrientation: StateOrientation
    ): StatusApplication()
}

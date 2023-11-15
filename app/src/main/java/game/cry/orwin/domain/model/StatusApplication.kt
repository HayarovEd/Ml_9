package game.cry.orwin.domain.model

sealed class StatusApplication {
    object Loading: StatusApplication()
    object NoConnect : StatusApplication()

    class Web (
        val url: String,
        val orientation: String
    ): StatusApplication()
}

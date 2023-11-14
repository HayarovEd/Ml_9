package game.cry.orwin.ui

import game.cry.orwin.domain.model.StatusApplication


data class MainState(
    val statusApplication: StatusApplication = StatusApplication.Loading/*Web(url = "https://ya.ru/", offerName = "Offer")*/,
)

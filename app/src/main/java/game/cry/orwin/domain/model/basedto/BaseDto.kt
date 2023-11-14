package game.cry.orwin.domain.model.basedto


import com.google.gson.annotations.SerializedName
import game.cry.orwin.domain.model.basedto.AppConfig

data class BaseDto(
    @SerializedName("app_config")
    val appConfig: AppConfig,
)
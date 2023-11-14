package game.cry.orwin.data


import game.cry.orwin.domain.model.basedto.BaseDto
import retrofit2.http.GET

interface ApiServer {
    @GET ("game1/db.json")
    suspend fun getDataDb () : BaseDto
}
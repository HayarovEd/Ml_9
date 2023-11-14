package game.cry.orwin.domain

import game.cry.orwin.data.Resource
import game.cry.orwin.domain.model.basedto.BaseDto

interface RepositoryServer {
    suspend fun getDataDb() : Resource<BaseDto>
}
package game.cry.orwin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import game.cry.orwin.data.Resource.Success
import game.cry.orwin.data.Resource.Error
import game.cry.orwin.domain.RepositoryServer
import game.cry.orwin.domain.model.StatusApplication.NoConnect
import game.cry.orwin.domain.model.StatusApplication.Web
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repositoryServer: RepositoryServer,
) : ViewModel() {

    private var _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            when (val result = repositoryServer.getDataDb()) {
                is Error -> {
                    _state.value.copy(
                        statusApplication = NoConnect
                    )
                        .updateStateUI()
                }
                is Success -> {
                    val url = result.data?.appConfig?.showedIconPrimary
                    if (url==null) {
                        _state.value.copy(
                            statusApplication = NoConnect
                        )
                            .updateStateUI()
                    } else {
                        _state.value.copy(
                            statusApplication = Web(url =url)
                        )
                            .updateStateUI()
                    }
                }
            }

        }
    }

    private fun MainState.updateStateUI() {
        _state.update {
            this
        }
    }
}
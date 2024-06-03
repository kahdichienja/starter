package com.example.mvvm.feature.users.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.core.util.Resource
import com.example.mvvm.feature.users.domain.usecase.GetUsersInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UserInfoViewModel @Inject constructor(private val getUsersInfo: GetUsersInfo): ViewModel(){
    private val _userInfoState = mutableStateOf(UsersInfoState())
    val usersInfoState: State<UsersInfoState> = _userInfoState

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val evenFlow = _eventFlow.asSharedFlow()
    init {
        getUsers()
    }
    private fun getUsers(){
        println("getUsers")
        viewModelScope.launch {
            getUsersInfo().onEach {
                res ->
                when(res){
                    is Resource.Success ->{
                        _userInfoState.value = usersInfoState.value.copy(
                            usersInfo = res.data ?: emptyList(),
                            isLoading = false
                        )
                        println("getUsers${_userInfoState.value.usersInfo.toString()}")
                    }
                    is Resource.Error -> {
                        _userInfoState.value = usersInfoState.value.copy(
                            usersInfo = res.data ?: emptyList(),
                            isLoading = false
                        )
                        _eventFlow.emit(UIEvent.ShowSnackBar(message = res.message?:"Unknown Error"))
                    }
                    is Resource.Loading -> {
                        _userInfoState.value = usersInfoState.value.copy(
                            usersInfo = res.data ?: emptyList(),
                            isLoading = true
                        )
                        _eventFlow.emit(UIEvent.ShowSnackBar(message = "Loading ..."))
                    }
                }
            }.launchIn(this)
        }
    }

    sealed class UIEvent{
        data class ShowSnackBar(val message: String): UIEvent()
    }
}
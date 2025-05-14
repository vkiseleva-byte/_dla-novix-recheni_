package com.example.nailservicestudio.ui.screen.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LogInViewModel() :
    ViewModel() {
    var state by mutableStateOf(LogInState())
        private set

    fun updateEmail(email: String) {
        state = state.copy(
            email = email,
            errorEmail = !emailValidate(email)
        )
        buttonEnabled()
    }

    fun updatePassword(password: String) {
        state = state.copy(password = password)
        buttonEnabled()
    }

    private fun emailValidate(email: String): Boolean {
        val regex = Regex("""([a-z0-9]+)@([a-z0-9]{3,})\.([a-z]{2,3})""")
        return regex.matches(email)
    }

    fun setAgree(isAgreed: Boolean) {
        state = state.copy(
            rememberAgree = isAgreed
        )
        buttonEnabled()
    }

    private fun buttonEnabled() {
        state =
            if (state.email.isNotEmpty() &&
                state.password.isNotEmpty() &&
                !state.errorEmail
            ) {
                state.copy(
                    buttonEnabled = true
                )
            } else {
                state.copy(
                    buttonEnabled = false
                )
            }
    }

    fun logIn() {
        state = state.copy(
            isLoading = true
        )
        viewModelScope.launch {
            try {
                state = if (state.password == "adminadmin" && state.email == "admin@mail.com") {
                    state.copy(
                        isLoading = false,
                        error = "true"
                    )
                } else {
                    state.copy(
                        isLoading = false,
                        error = "Вы ввели неправильные данные"
                    )
                }
            } catch (e: Exception) {
                state = state.copy(
                    isLoading = false,
                    error = e.message?.substringBefore('.') ?: "Произошла ошибка"
                )
            }
        }
    }

    fun dismissError() {
        state = state.copy(
            error = null
        )
    }
}

data class LogInState(
    val error: String? = null,
    val isLoading: Boolean = false,
    val email: String = "",
    val errorEmail: Boolean = false,
    val password: String = "",
    val buttonEnabled: Boolean = false,
    val rememberAgree: Boolean = false
)

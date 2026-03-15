package com.example.tecnicaltaskem.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnicaltaskem.presentation.InputFieldValidatorUtility
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

class LoginViewModel : ViewModel() {

    private val validator = InputFieldValidatorUtility()

    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")

    val isLoginButtonEnabled: StateFlow<Boolean> = combine(_email, _password) { email, password ->
        validator.isEmailValid(email) && validator.isPasswordValid(password)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(1000),
        initialValue = false
    )

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        _password.value = newPassword
    }
}

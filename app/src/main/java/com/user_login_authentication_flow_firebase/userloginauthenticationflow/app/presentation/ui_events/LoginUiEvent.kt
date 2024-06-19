package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events

sealed class LoginUiEvent {

    data class EmailChanged(val email: String): LoginUiEvent()
    data class PasswordChanged(val password: String): LoginUiEvent()


    object Login: LoginUiEvent()
}
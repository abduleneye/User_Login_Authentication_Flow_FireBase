package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events

sealed class UiEvent {
    data class FirstnameChanged(val firstName: String): UiEvent()
    data class LastnameChanged(val lastName: String): UiEvent()
    data class EmailChanged(val email: String): UiEvent()
    data class PasswordChanged(val password: String): UiEvent()

    object Register: UiEvent()

}
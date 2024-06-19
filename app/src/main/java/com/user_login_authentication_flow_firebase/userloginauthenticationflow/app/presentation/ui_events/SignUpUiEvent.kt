package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events

sealed class SignUpUiEvent {
    data class FirstnameChanged(val firstName: String): SignUpUiEvent()
    data class LastnameChanged(val lastName: String): SignUpUiEvent()
    data class EmailChanged(val email: String): SignUpUiEvent()
    data class PasswordChanged(val password: String): SignUpUiEvent()
    data class PrivacyPolicyCheckBoxClicked(val status: Boolean): SignUpUiEvent()
    data object SignUp: SignUpUiEvent()

}
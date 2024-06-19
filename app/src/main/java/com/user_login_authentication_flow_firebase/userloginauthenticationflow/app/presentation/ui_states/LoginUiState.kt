package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states

data class LoginUiState(
    var email: String = "",
    var password: String = "",

    var emailError: Boolean = false,
    var passwordError: Boolean = false,
)

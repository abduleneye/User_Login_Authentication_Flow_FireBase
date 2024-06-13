package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states

data class RegistrationUiState (
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",

    var firstNameError: Boolean = false,
    var lastNameError: Boolean = false,
    var emailError: Boolean = false,
    var passwordError: Boolean = false
)
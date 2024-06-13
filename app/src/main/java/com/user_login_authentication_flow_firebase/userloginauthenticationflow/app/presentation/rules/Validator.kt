package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.rules

object Validator {
    fun validateFirstName(fName: String): ValidationResult{

        return ValidationResult(
            (!fName.isNullOrEmpty() && fName.length >= 6)
        )

    }

    fun validateLastName(lName: String): ValidationResult{
        return ValidationResult(
            (!lName.isNullOrEmpty() && lName.length >= 6)
        )
    }

    fun validateEmail(email: String):ValidationResult{
        return ValidationResult(
            (!email.isNullOrEmpty())
        )

    }
    fun validatePassword(password: String): ValidationResult{
        return ValidationResult(
            (!password.isNullOrEmpty() && password.length >= 4)
        )
    }
}

data class ValidationResult(
    val status: Boolean  = false
)
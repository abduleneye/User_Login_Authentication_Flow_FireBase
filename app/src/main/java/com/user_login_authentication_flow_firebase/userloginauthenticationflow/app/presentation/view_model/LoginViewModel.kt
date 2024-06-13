package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.rules.Validator
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.UiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states.RegistrationUiState

class LoginViewModel: ViewModel() {

    private val TAG = LoginViewModel::class.simpleName

    var registrationUiState = mutableStateOf(RegistrationUiState())

    fun onEvent(event: UiEvent){
        validateDataWithRules()
        when(event){
            is UiEvent.FirstnameChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is UiEvent.EmailChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    email = event.email
                )
                printState()

            }
            is UiEvent.LastnameChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    lastName = event.lastName
                )
                printState()

            }
            is UiEvent.PasswordChanged -> {
                registrationUiState.value = registrationUiState.value.copy(
                    password = event.password
                )
                printState()

            }

            UiEvent.Register -> {
                signUp()
                printState()

                validateDataWithRules()
            }
        }

    }

    private fun validateDataWithRules(){
        val fNameResult = Validator.validateFirstName(
            fName = registrationUiState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = registrationUiState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = registrationUiState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = registrationUiState.value.password
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "fNameResult = ${fNameResult}")
        Log.d(TAG, "lNameResult = ${lNameResult}")
        Log.d(TAG, "emailResult = ${emailResult}")
        Log.d(TAG, "passwordResult = ${passwordResult}")

        registrationUiState.value = registrationUiState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status
        )







    }


    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, registrationUiState.value.toString())
    }

    private fun signUp(){
        Log.d(TAG, "Inside_signUp")

    }
}
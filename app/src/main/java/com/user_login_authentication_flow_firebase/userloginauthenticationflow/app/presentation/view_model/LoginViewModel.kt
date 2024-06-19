package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.PostOfficeAppRouter
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.Screen
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.rules.Validator
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.screens.PostOfficeApp
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.LoginUiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states.LoginUiState
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states.SignUpUiState

class LoginViewModel: ViewModel() {

    val TAG = "Login_tag"

    var loginUiState = mutableStateOf(LoginUiState())

    var allLoginValidationsPassed = mutableStateOf(false)

    var loginInProgress = mutableStateOf(false)

    fun onEvent(event: LoginUiEvent){
        when(event){

            is LoginUiEvent.PasswordChanged ->{
                loginUiState.value = loginUiState.value.copy(
                    password = event.password
                )
            }
            is LoginUiEvent.EmailChanged ->{
                loginUiState.value = loginUiState.value.copy(
                    email = event.email
                )

            }
            is LoginUiEvent.Login -> {
                login()
            }

            else -> {

            }
        }

        validateLoginUiData()
    }



    private fun validateLoginUiData(){

        val emailResult = Validator.validateEmail(
            email = loginUiState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = loginUiState.value.password
        )



        Log.d(TAG, "Inside_validateDataWithRules")

        Log.d(TAG, "emailResult = ${emailResult}")
        Log.d(TAG, "passwordResult = ${passwordResult}")


        loginUiState.value = loginUiState.value.copy(

            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )

        if (emailResult.status && passwordResult.status){
            allLoginValidationsPassed.value = true
        }else{
            allLoginValidationsPassed.value = false

        }






    }

    private fun login() {
        loginInProgress.value = true


        val email = loginUiState.value.email
        val password = loginUiState.value.password

        FirebaseAuth
            .getInstance()
            .signInWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d(TAG, "Inside login success")
                Log.d(TAG, "${it.isSuccessful }")

                if(it.isSuccessful){
                    loginInProgress.value = false
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }

            }
            .addOnFailureListener{
                Log.d(TAG, "Inside login failed")
                Log.d(TAG, "${it.message}")

            }
    }



}
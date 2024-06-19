package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.PostOfficeAppRouter
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.Screen
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.rules.Validator
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.LoginUiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.SignUpUiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_states.SignUpUiState

class SignUpViewModel: ViewModel() {

    private val TAG = SignUpViewModel::class.simpleName

    var signUpUiState = mutableStateOf(SignUpUiState())

    var allSignUpValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: SignUpUiEvent){
        validateDataWithRules()
        when(event){
            is SignUpUiEvent.FirstnameChanged -> {
                signUpUiState.value = signUpUiState.value.copy(
                    firstName = event.firstName
                )
                printState()
            }

            is SignUpUiEvent.EmailChanged -> {
                signUpUiState.value = signUpUiState.value.copy(
                    email = event.email
                )
                printState()

            }
            is SignUpUiEvent.LastnameChanged -> {
                signUpUiState.value = signUpUiState.value.copy(
                    lastName = event.lastName
                )
                printState()

            }
            is SignUpUiEvent.PasswordChanged -> {
                signUpUiState.value = signUpUiState.value.copy(
                    password = event.password
                )
                printState()

            }

            SignUpUiEvent.SignUp -> {
                signUp()
                printState()

                validateDataWithRules()
            }

            is SignUpUiEvent.PrivacyPolicyCheckBoxClicked -> {
                signUpUiState.value = signUpUiState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }

        }

    }

    private fun validateDataWithRules(){
        val fNameResult = Validator.validateFirstName(
            fName = signUpUiState.value.firstName
        )
        val lNameResult = Validator.validateLastName(
            lName = signUpUiState.value.lastName
        )
        val emailResult = Validator.validateEmail(
            email = signUpUiState.value.email
        )

        val passwordResult = Validator.validatePassword(
            password = signUpUiState.value.password
        )

        val privacyPolicyResult = Validator.validatePrivacyPolicyAcceptance(
            statusValue = signUpUiState.value.privacyPolicyAccepted
        )

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "fNameResult = ${fNameResult}")
        Log.d(TAG, "lNameResult = ${lNameResult}")
        Log.d(TAG, "emailResult = ${emailResult}")
        Log.d(TAG, "passwordResult = ${passwordResult}")
        Log.d(TAG, "privacyPolicyResult = ${privacyPolicyResult}")


        signUpUiState.value = signUpUiState.value.copy(
            firstNameError = fNameResult.status,
            lastNameError = lNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        if (fNameResult.status && lNameResult.status && emailResult.status && passwordResult.status && privacyPolicyResult.status){
            allSignUpValidationsPassed.value = true
        }else{
            allSignUpValidationsPassed.value = false

        }






    }


    private fun printState(){
        Log.d(TAG, "Inside_printState")
        Log.d("STATES", signUpUiState.value.toString())
    }

    private fun signUp(){
        Log.d(TAG, "Inside_signUp")
        printState()
        createUserInFireBase(
            email = signUpUiState.value.email,
            password = signUpUiState.value.password,
        )

    }

    private fun createUserInFireBase(email: String, password: String){
        signUpInProgress.value = true
        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                Log.d("FIRED", "Inside_OnCompleteListener")
                Log.d("FIRED", "${it.isSuccessful}")

                signUpInProgress.value = false

                if (it.isSuccessful){
                    PostOfficeAppRouter.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener{
                Log.d("FIRED", "Inside_OnFailureListener")
                Log.d("FIRED", "${it.message}")
                Log.d("FIRED", "${it.localizedMessage}")


            }




    }

     fun logOut(){

         val firebaseAuth = FirebaseAuth.getInstance()

         firebaseAuth.signOut()

         val authStateListener = AuthStateListener{

             if (it.currentUser == null){

                 Log.d("SIGNED_OUT", "Inside signed out successfull")
                 PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
             }else{
                 Log.d("SIGNED_OUT", "Inside signed out failed")

             }


         }

         firebaseAuth.addAuthStateListener(authStateListener)


     }
}
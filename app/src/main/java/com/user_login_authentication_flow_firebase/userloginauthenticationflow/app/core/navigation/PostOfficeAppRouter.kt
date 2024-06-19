package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen() {
    object SignUpScreen: Screen()
    object TermsAndConditionScreen: Screen()

    object LoginScreen: Screen()

    object HomeScreen: Screen()

}

object PostOfficeAppRouter{

    var currentScreen: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)


    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}
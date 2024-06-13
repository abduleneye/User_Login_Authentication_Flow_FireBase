package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.PostOfficeAppRouter
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.Screen

@Composable
fun PostOfficeApp(){
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {

        Crossfade(targetState = PostOfficeAppRouter.currentScreen, label = "") { currentState ->
            when(currentState.value){
                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }
                is Screen.TermsAndConditionScreen -> {
                    TermsAndConditionScreen()
                }
                is Screen.LoginScreen -> {
                    LoginScreen()
                }
            }

        }

       // SignUpScreen()

    }

}
package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.ButtonComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.HeadingTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model.SignUpViewModel

@Composable
fun HomeScreen(signUpViewModel: SignUpViewModel = viewModel()){
    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            HeadingTextComponent(value = "Home")

            ButtonComponent(value = "LogOut", onButtonClicked = {
                signUpViewModel.logOut()
            }, isEnabled = true)


        }

    }
}

@Preview
@Composable
fun HomeScreenPreview(){

}
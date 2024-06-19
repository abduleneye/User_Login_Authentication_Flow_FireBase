package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.R
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.PostOfficeAppRouter
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.Screen
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation.SystemBackButtonHandler
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.ButtonComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.ClickableLoginTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.DividerTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.HeadingTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.MyTextFieldComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.NormalTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.PasswordTextFieldComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.UnderlinedTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.LoginUiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model.LoginViewModel


@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()){


    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){

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
                NormalTextComponent(value = stringResource(id = R.string.login))
                HeadingTextComponent(value = stringResource(id = R.string.welcome))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(labelValue = stringResource(id = R.string.email), leadingIcon = null, onTextSelected = {
                    loginViewModel.onEvent(LoginUiEvent.EmailChanged(it))
                }, errorStatus = loginViewModel.loginUiState.value.emailError)
                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), leadingIcon = null, onTextSelected = {
                    loginViewModel.onEvent(LoginUiEvent.PasswordChanged(it))

                }, errorStatus = loginViewModel.loginUiState.value.passwordError, trailingIcon = null)
                Spacer(modifier = Modifier.height(40.dp))
                UnderlinedTextComponent(value = stringResource(id = R.string.forgot_password))
                Spacer(modifier = Modifier.height(40.dp))
                ButtonComponent(value = stringResource(id = R.string.login), onButtonClicked = {
                    loginViewModel.onEvent(LoginUiEvent.Login)
                }, isEnabled = loginViewModel.allLoginValidationsPassed.value)
                Spacer(modifier = Modifier.height(20.dp))
                DividerTextComponent()
                ClickableLoginTextComponent(tryingToLogin = false, onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
                })


            }

        }

        if (loginViewModel.loginInProgress.value){
            CircularProgressIndicator()
        }
        


    }

//    SystemBackButtonHandler{
//        PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
//    }

}

@Preview
@Composable
fun LoginScreenPreview(){
    LoginScreen()
}
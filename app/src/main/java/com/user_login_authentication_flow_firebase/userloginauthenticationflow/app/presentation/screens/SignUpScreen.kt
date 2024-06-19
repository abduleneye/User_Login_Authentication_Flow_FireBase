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
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.ButtonComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.HeadingTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.MyTextFieldComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.NormalTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.PasswordTextFieldComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.CheckBoxComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.ClickableLoginTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.DividerTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.ui_events.SignUpUiEvent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.view_model.SignUpViewModel


@Composable
fun SignUpScreen(signUpViewModel: SignUpViewModel = viewModel()){

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
                NormalTextComponent(value = stringResource(id = R.string.hello))
                HeadingTextComponent(value = stringResource(id = R.string.create_account))
                Spacer(modifier = Modifier.height(20.dp))
                MyTextFieldComponent(labelValue = stringResource(id = R.string.first_name), null, onTextSelected = {
                    signUpViewModel.onEvent(SignUpUiEvent.FirstnameChanged(it))
                }, errorStatus = signUpViewModel.signUpUiState.value.firstNameError)
                MyTextFieldComponent(labelValue = stringResource(id = R.string.last_name), null,onTextSelected = {
                    signUpViewModel.onEvent(SignUpUiEvent.LastnameChanged(it))

                }, errorStatus = signUpViewModel.signUpUiState.value.lastNameError)
                MyTextFieldComponent(labelValue = stringResource(id = R.string.email), null,onTextSelected = {
                    signUpViewModel.onEvent(SignUpUiEvent.EmailChanged(it))

                }, errorStatus = signUpViewModel.signUpUiState.value.emailError)
                PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), null, null, onTextSelected = {
                    signUpViewModel.onEvent(SignUpUiEvent.PasswordChanged(it))

                },errorStatus = signUpViewModel.signUpUiState.value.passwordError)
                CheckBoxComponent(onTextSelected = {
                    PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionScreen)
                },
                    onCheckedChange = {
                        signUpViewModel.onEvent(SignUpUiEvent.PrivacyPolicyCheckBoxClicked(it))
                    })

                Spacer(modifier = Modifier.height(40.dp))

                ButtonComponent(value = stringResource(id = R.string.register), onButtonClicked = {
                    signUpViewModel.onEvent(SignUpUiEvent.SignUp)
                }, isEnabled = signUpViewModel.allSignUpValidationsPassed.value)

                Spacer(modifier = Modifier.height(20.dp))

                DividerTextComponent()

                ClickableLoginTextComponent(tryingToLogin = true, onTextSelected = {

                    PostOfficeAppRouter.navigateTo(Screen.LoginScreen)

                })




            }




        }

        if (signUpViewModel.signUpInProgress.value){
            CircularProgressIndicator()
        }
    }



}

@Composable
@Preview
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen(signUpViewModel = SignUpViewModel())
}
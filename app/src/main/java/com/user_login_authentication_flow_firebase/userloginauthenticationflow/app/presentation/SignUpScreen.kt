package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.R
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.HeadingTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.MyTextFieldComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.NormalTextComponent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components.PasswordTextFieldComponent

@Composable
fun SignUpScreen(){

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
            MyTextFieldComponent(labelValue = stringResource(id = R.string.first_name), null)
            MyTextFieldComponent(labelValue = stringResource(id = R.string.last_name), null)
            MyTextFieldComponent(labelValue = stringResource(id = R.string.email), null)
            PasswordTextFieldComponent(labelValue = stringResource(id = R.string.password), null)

        }




    }

}

@Composable
@Preview
fun DefaultPreviewOfSignUpScreen(){
    SignUpScreen()
}
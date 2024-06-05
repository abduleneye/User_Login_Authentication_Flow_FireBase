package com.user_login_authentication_flow_firebase.userloginauthenticationflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.PostOfficeApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostOfficeApp()

        }
    }
}


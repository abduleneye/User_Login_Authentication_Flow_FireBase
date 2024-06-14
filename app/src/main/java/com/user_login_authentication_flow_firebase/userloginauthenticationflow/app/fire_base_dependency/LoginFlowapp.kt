package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.fire_base_dependency

import android.app.Application
import com.google.firebase.FirebaseApp

class LoginFlowApp: Application() {

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }
}
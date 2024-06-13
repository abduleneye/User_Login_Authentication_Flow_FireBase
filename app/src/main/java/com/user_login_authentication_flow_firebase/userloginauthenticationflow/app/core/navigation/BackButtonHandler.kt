package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.core.navigation

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.lifecycle.compose.LocalLifecycleOwner

private val localBackPressedDispatcher = staticCompositionLocalOf<OnBackPressedDispatcherOwner?>{
    null
}

private class ComposableBackNavigationHandler(enabled: Boolean): OnBackPressedCallback(enabled) {
    lateinit var onBackPressed: () -> Unit
    override fun handleOnBackPressed() {
        TODO("Not yet implemented")
    }
}

@Composable
internal fun ComposableHandler(
    enabled: Boolean = true,
    onBackPressed: () -> Unit
){
    val dispatcher = (localBackPressedDispatcher.current ?: return).onBackPressedDispatcher
    val handler = remember{
        ComposableBackNavigationHandler(enabled = enabled)

    }

    DisposableEffect(key1 = dispatcher) {
        dispatcher.addCallback(handler)
        onDispose { handler.remove() }

    }

    LaunchedEffect(enabled) {
        handler.isEnabled = enabled
        handler.onBackPressed = onBackPressed

    }

}

@Composable
internal fun SystemBackButtonHandler(onBackPressed: () -> Unit){
    CompositionLocalProvider(
        localBackPressedDispatcher provides LocalLifecycleOwner.current as ComponentActivity
    ){

        ComposableHandler {
            onBackPressed()
        }

    }

}
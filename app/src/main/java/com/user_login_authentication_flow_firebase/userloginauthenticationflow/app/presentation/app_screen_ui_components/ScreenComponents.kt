package com.user_login_authentication_flow_firebase.userloginauthenticationflow.app.presentation.app_screen_ui_components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.R
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.ui.theme.GrayColor
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.ui.theme.Purple40
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.ui.theme.TextColor
import com.user_login_authentication_flow_firebase.userloginauthenticationflow.ui.theme.componentShapes

@Composable
fun NormalTextComponent(value: String){
    Text(

        text =  value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center

    )

}
@Composable
fun HeadingTextComponent(value: String){
    Text(

        text =  value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center

    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldComponent(labelValue: String, leadingIcon: Painter?, onTextSelected: (String) -> Unit, errorStatus: Boolean = false){
    val textValue = remember {
        mutableStateOf("")
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small)
        ,
           // .background(color = colorResource(id = R.color.bgColor)),
        value = textValue.value,
        onValueChange =  {
                         textValue.value = it
            onTextSelected(it)
        },
        label = { Text(text = labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            disabledContainerColor = colorResource(id = R.color.bgColor)


        ),
        keyboardOptions = KeyboardOptions.Default,
        leadingIcon = {
           // Icon(ImageVector = Icons.Default.Person, contentDescription = "")
        },
        isError = !errorStatus
    )
}


@Composable
fun PasswordTextFieldComponent(labelValue: String, leadingIcon: Painter?, trailingIcon: Painter?, onTextSelected: (String) -> Unit,errorStatus: Boolean = false){
    val password = remember {
        mutableStateOf("")
    }

    val passwordVisible = remember {
        mutableStateOf(false)
    }


    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small)
        ,
        // .background(color = colorResource(id = R.color.bgColor)),
        value = password.value,
        onValueChange =  {
            password.value = it
            onTextSelected(it)
        },
        label = { Text(text = labelValue)},
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.colorPrimary),
            focusedLabelColor = colorResource(id = R.color.colorPrimary),
            cursorColor = colorResource(id = R.color.colorPrimary),
            disabledContainerColor = colorResource(id = R.color.bgColor)


        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Password, contentDescription = "password filled")
        },

        trailingIcon = {
            val iconImage = if (passwordVisible.value){
                Icons.Filled.Visibility
            }else{
                Icons.Filled.VisibilityOff
            }
                       val description = if(passwordVisible.value){
                           stringResource(id = R.string.hide_password)
                       }else{
                           stringResource(id = R.string.show_password)
                       }
            
            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        //Intuitive hides and show the password based on condition
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else
        PasswordVisualTransformation(),
        isError = !errorStatus

    )
}

@Composable
fun CheckBoxComponent(onTextSelected: (String) -> Unit, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){

        val checkedState = remember {
            mutableStateOf(false)
        }

        Checkbox(checked = checkedState.value, onCheckedChange = {
            checkedState.value = !checkedState.value
            onCheckedChange.invoke(it)
        })

       // NormalTextComponent(value = value)
        ClickableTextComponent(onTextSelected = onTextSelected)

    }

}

@Composable
fun ClickableTextComponent(onTextSelected: (String) -> Unit) {

    val initialText = "By continuing you accept our "
    val privacyAndPolicyText = " Privacy policy "
    val andText = " and "
    val termsAndConditionText = " Terms of Use "
    val context = LocalContext.current

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Color.Red)){
            pushStringAnnotation(tag = privacyAndPolicyText, annotation = privacyAndPolicyText)
            append(privacyAndPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = Color.Red)){
            pushStringAnnotation(tag = termsAndConditionText, annotation = termsAndConditionText)
            append(termsAndConditionText)
        }

    }
        
       // Text(text = annotatedString)
       ClickableText(text = annotatedString, onClick = {offset ->
           annotatedString.getStringAnnotations(offset, offset)
               .firstOrNull()?.also {span ->
                   Log.d("ClickableTextComponent", "${span.item}")
                   Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                   if (span.item == termsAndConditionText || span.item == privacyAndPolicyText){
                       onTextSelected(span.item)

                   }

               }

       })

//            onClick = {it -> }) {it ->
//
//        }


        }

@Composable
fun ButtonComponent(value: String, onButtonClicked: () -> Unit, isEnabled: Boolean = false){
    Button(
        onClick = {
                  onButtonClicked.invoke()
        },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent),
        enabled = isEnabled
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(Color.LightGray, Color.DarkGray)
                    ),
                    shape = RoundedCornerShape(50.dp)

                ),
            contentAlignment = Alignment.Center

        ){

            Text(
                text = value,
                fontSize = 18.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
                )

        }


    }
}

@Composable
fun DividerTextComponent(){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp)

        Text(
            modifier = Modifier
                .padding(8.dp),
            text = stringResource(id = R.string.or),
            fontSize = 18.sp,
            color = TextColor)

        Divider(modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
            color = GrayColor,
            thickness = 1.dp)

    }
}


@Composable
fun ClickableLoginTextComponent(tryingToLogin: Boolean = true, onTextSelected: (String) -> Unit) {

    val initialText = if(tryingToLogin)"Already have an account? " else "Don't have an account yet?"
    val loginText = if(tryingToLogin) "Login" else "SignUp"
    val context = LocalContext.current

    val annotatedString = buildAnnotatedString {
        append(initialText)
        withStyle(style = SpanStyle(color = Purple40)){
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    // Text(text = annotatedString)
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString, onClick = {offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also {span ->
                Log.d("ClickableTextComponent", "${span.item}")
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()

                if (span.item == loginText){
                    onTextSelected(span.item)
                    Toast.makeText(context, "Login Text Clicked", Toast.LENGTH_SHORT).show()


                }

            }

    })

//            onClick = {it -> }) {it ->
//
//        }


}

@Composable
fun UnderlinedTextComponent(value: String){
    Text(

        text =  value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorGray),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline

    )

}

package co.edu.eam.reporteseam.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import co.edu.eam.reporteseam.R
import co.edu.eam.reporteseam.ui.components.TextFieldForm

@Composable
fun LoginScreen() {
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var error by remember { mutableStateOf(false) }
        val context = LocalContext.current

        FormLogin(
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            onLoginClick = {

                if (email.isBlank() && password.isBlank()) {
                    error = true
                }else{
                    Toast.makeText(context, "Login correcto", Toast.LENGTH_SHORT).show()
                }

            }
        )

    }
}


@Composable
fun FormLogin(
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit
){

    Column(
        modifier = Modifier.padding(30.dp).fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterVertically)
    ) {

        TextFieldForm(
            value = email,
            onValueChange = onEmailChange,
            onValidate = { !Patterns.EMAIL_ADDRESS.matcher(it).matches() },
            errorText = "El email no es válido",
            placeholderText = "Email"
        )

        TextFieldForm(
            value = password,
            onValueChange = onPasswordChange,
            onValidate = { password.isBlank() },
            errorText = "La contraseña no puede estar vacía",
            isPassword = true,
            placeholderText = "Contraseña"
        )

        Button(
            onClick = onLoginClick
        ) {
            //Spacer(Modifier.size(ButtonDefaults.IconSpacing))

            Text(text = "Iniciar sesión")
        }

        Text(text = "¿No tienes una cuenta?")

        Button(
            onClick = {
                //TODO: Ir a la pantalla de registro
            }
        ) {
            //Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Crear cuenta")
        }


    }

}
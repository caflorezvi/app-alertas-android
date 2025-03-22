package co.edu.eam.reporteseam.ui.screens

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.AddCircle
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import co.edu.eam.reporteseam.R
import co.edu.eam.reporteseam.ui.components.TextFieldForm
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen() {

    val context = LocalContext.current

    var nombre by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }
    var direccion by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var fechaNacimiento by rememberSaveable { mutableStateOf("") }

    var password by rememberSaveable { mutableStateOf("") }
    var password2 by rememberSaveable { mutableStateOf("") }

    var showDatePicker by rememberSaveable { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier
                .size(250.dp)
                .padding(top = 50.dp, bottom = 30.dp),
            imageVector = Icons.Rounded.AccountCircle,
            contentDescription = "Imagen de perfil"
        )

        TextFieldForm(
            value = nombre,
            onValueChange = {
                nombre = it
            },
            onValidate = { nombre.isEmpty() || nombre.length > 30 },
            errorText = "El nombre debe tener entre 1 y 30 caracteres",
            placeholderText = "Nombre"
        )

        TextFieldForm(
            value = telefono,
            onValueChange = {
                telefono = it
            },
            onValidate = { telefono.isEmpty() },
            errorText = "El teléfono no puede estar vacío",
            placeholderText = "Número de teléfono"
        )

        TextFieldForm(
            value = direccion,
            onValueChange = {
                direccion = it
            },
            onValidate = { direccion.isEmpty() },
            errorText = "La dirección no puede estar vacía",
            placeholderText = "Dirección de residencia"
        )

        TextFieldForm(
            value = email,
            onValueChange = {
                email = it
            },
            onValidate = { !Patterns.EMAIL_ADDRESS.matcher(it).matches() },
            errorText = "El email no es válido",
            placeholderText = "Email"
        )

        TextFieldForm(
            value = password,
            onValueChange = {
                password = it
            },
            onValidate = { password.length < 6 },
            errorText = "La contraseña debe tener al menos 6 caracteres",
            placeholderText = "Contraseña",
            isPassword = true
        )

        TextFieldForm(
            value = password2,
            onValueChange = {
                password2 = it
            },
            onValidate = { password2 != password },
            errorText = "Las contraseñas no coinciden",
            placeholderText = "Repetir contraseña",
            isPassword = true
        )

        TextFieldForm(
            value = fechaNacimiento,
            onValidate = { fechaNacimiento.isBlank() },
            errorText = "La fecha no puede estar vacía",
            placeholderText = "Fecha de nacimiento",
            isReadOnly = true,
            trailingIcon = {
                IconButton(onClick = { showDatePicker = !showDatePicker }) {
                    Icon(
                        imageVector = Icons.Rounded.DateRange,
                        contentDescription = "Seleccionar fecha"
                    )
                }
            }
        )

        Button(
            onClick = {

            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Icon(
                imageVector = Icons.Rounded.AddCircle,
                contentDescription = "Nuevo usuario"
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Registrarse")
        }

        Spacer(modifier = Modifier.height( 30.dp ) )

        if(showDatePicker) {

            DatePickerDialog(
                onDismissRequest = {
                    showDatePicker = false
                },
                confirmButton = {
                    TextButton(
                        onClick = {

                            val date = datePickerState.selectedDateMillis

                            if(date != null) {

                                val dateObject = Date(date)
                                if( dateObject.after(Date()) ) {
                                    Toast.makeText(context, "La fecha no puede ser posterior a la actual", Toast.LENGTH_SHORT).show()
                                    return@TextButton
                                }

                                val formattedDate = SimpleDateFormat(
                                    "MMM dd, yyyy",
                                    Locale.getDefault()
                                ).format(date)

                                fechaNacimiento = formattedDate
                                showDatePicker = false
                            }
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            showDatePicker = false
                        }
                    ) {
                        Text("Cancelar")
                    }
                }
            ) {
                DatePicker(state = datePickerState)
            }

        }

    }
}

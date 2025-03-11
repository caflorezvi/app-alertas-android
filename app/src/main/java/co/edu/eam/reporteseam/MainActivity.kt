package co.edu.eam.reporteseam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import co.edu.eam.reporteseam.componentes.Usuario
import org.w3c.dom.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //val usuarios = listOf("Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela","Pedro", "Carlos", "Laura", "Marcela")

        setContent {
            FormularioLogin()
        }
    }
}

@Composable
fun ListaUsuarios(
    usuarios: List<String>
){
    LazyColumn{
        items(usuarios) {
            Usuario(
                nombre = it
            )
        }
    }
}

@Composable
fun FormularioLogin(){

    val (email, setEmail) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }
    var mensajeBienvenida by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Input(
            valor = email,
            setValor = setEmail,
            mensajeError = "Debe ingresar un email",
            etiqueta = "Email"
        )

        Input(
            valor = password,
            setValor = setPassword,
            mensajeError = "Debe ingresar una contraseña",
            etiqueta = "Password"
        )

        Button(
            onClick = {
               if(email.isNotEmpty() && password == "bbb"){
                   mensajeBienvenida = "Bienvenido $email"
               }else{
                   mensajeBienvenida = "Credenciales incorrectas"
               }
            }
        ) {
            Text(
                text = "Iniciar sesión"
            )
        }

        Text(
            text = mensajeBienvenida
        )


    }


}

@Composable
fun Input(
    valor: String = "",
    setValor: (String) -> Unit = {},
    isError: Boolean = false,
    etiqueta: String,
    mensajeError: String = "",
){

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = valor,
        onValueChange = {
            setValor(it)
        },
        isError = isError,
        supportingText = {
            if (isError) {
                Text(
                    text = mensajeError
                )
            }
        },
        label = {
            Text(
                text = etiqueta
            )
        }
    )

}

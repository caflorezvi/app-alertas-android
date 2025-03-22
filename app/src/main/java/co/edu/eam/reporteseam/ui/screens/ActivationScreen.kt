package co.edu.eam.reporteseam.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import co.edu.eam.reporteseam.R

@Composable
fun ActivationScreen(){

    var codigo = remember { mutableStateListOf("", "", "", "", "") }

    Column(
        modifier = Modifier
            .fillMaxSize().padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(25.dp, Alignment.CenterVertically)
    ) {

        Image(
            modifier = Modifier.width(200.dp),
            bitmap = ImageBitmap.imageResource(id = R.drawable.img_activation),
            contentDescription = "Logo de la aplicación"
        )

        Text(
            text = "Ingrese el código de activación enviado a su correo electrónico",
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp, Alignment.CenterHorizontally)
        ) {

            for(i in 0..4){

                OutlinedTextField(
                    modifier = Modifier.width(50.dp),
                    value = codigo[i],
                    onValueChange = {
                        if(codigo[i].isEmpty()){
                            codigo[i] = it
                        }
                    }
                )

            }

        }

        Button(
            onClick = {
                //TODO: Verificar el código ingresado
            }
        ) {
            Icon(
                contentDescription = "Botón para verificar un código",
                imageVector = Icons.Rounded.Check
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text(text = "Verificar código")
        }


    }

}
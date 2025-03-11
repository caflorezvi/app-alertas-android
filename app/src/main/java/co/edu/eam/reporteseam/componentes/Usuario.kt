package co.edu.eam.reporteseam.componentes

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp

@Composable
fun Usuario(
    nombre:String
){
    Text(
        text = nombre,
        fontSize = 40.sp
    )
}
package co.edu.eam.reporteseam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.edu.eam.reporteseam.ui.screens.ActivationScreen
import co.edu.eam.reporteseam.ui.screens.HomeScreen
import co.edu.eam.reporteseam.ui.screens.LoginScreen
import co.edu.eam.reporteseam.ui.screens.SignUpScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //ActivationScreen()
            LoginScreen()
            //SignUpScreen()
        }
    }
}
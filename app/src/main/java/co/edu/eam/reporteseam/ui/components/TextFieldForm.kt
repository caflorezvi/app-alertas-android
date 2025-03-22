package co.edu.eam.reporteseam.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.error
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TextFieldForm(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit = {},
    onValidate: (String) -> Boolean,
    errorText: String,
    placeholderText: String,
    singleLine: Boolean = true,
    isPassword: Boolean = false,
    isReadOnly: Boolean = false,
    trailingIcon: @Composable (() -> Unit)? = null
){

    var isError by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isError = onValidate(it)
        },
        singleLine = singleLine,
        isError = isError,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        supportingText = {
            Text(
                text = if (isError) errorText else "",
                modifier = Modifier.clearAndSetSemantics {  }
            )
        },
        label = { Text(placeholderText) },
        modifier = modifier.fillMaxWidth().semantics {
            if (isError) {
                error(errorText)
            }
        },
        readOnly = isReadOnly,
        trailingIcon = trailingIcon
    )

}

package br.com.safe.pass.components.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.R
import br.com.safe.pass.components.factory.filterFactory
import br.com.safe.pass.components.utils.colorTheme
import br.com.safe.pass.components.utils.converterSizePasswordToNumber
import br.com.safe.pass.theme.Themes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu(
    selectedValue: String,
    items: List<Int>,
    label: String,
    isError: Boolean = false,
    onValueChangedEvent: (Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(value = false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier
    ) {
        OutlinedTextField(
            readOnly = true,
            value = selectedValue,
            onValueChange = {},
            label = { Description(description = label) },
            isError = isError,
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.filter),
                    contentDescription = label,
                    tint = Themes.colors.primary
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = colorTheme(error = isError),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            shape = RoundedCornerShape(size = Themes.size.spaceSize16),
            textStyle = Themes.typography.description
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.background(color = Themes.colors.background)
        ) {
            items.forEach {
                DropdownMenuItem(
                    text = {
                        Description(description = stringResource(id = it))
                    },
                    onClick = {
                        expanded = false
                        onValueChangedEvent(converterSizePasswordToNumber(it))
                    },
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun DropdownMenuScreenPreview() {
    DropdownMenu(
        selectedValue = "Brazil",
        label = stringResource(id = R.string.size_password),
        items = filterFactory,
        onValueChangedEvent = {}
    )
}

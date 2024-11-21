package br.com.safe.pass.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.R
import br.com.safe.pass.components.factory.filterFactory
import br.com.safe.pass.components.ui.Action
import br.com.safe.pass.components.ui.Button
import br.com.safe.pass.components.ui.DropdownMenu
import br.com.safe.pass.components.ui.Title
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.components.utils.converterSizePassword
import br.com.safe.pass.repository.generatePassword
import br.com.safe.pass.theme.Themes

@Composable
fun GeneratePasswordScreen(
    modifier: Modifier = Modifier
) {
    var hash: String by remember { mutableStateOf(value = "") }
    var uniqueChars by remember { mutableStateOf(value = true) }
    var lowercase by remember { mutableStateOf(value = true) }
    var uppercase by remember { mutableStateOf(value = false) }
    var numbers by remember { mutableStateOf(value = false) }
    var specialChars by remember { mutableStateOf(value = false) }
    var length: Int by remember { mutableIntStateOf(value = 8) }
    Column(
        modifier = modifier
            .background(color = Themes.colors.background)
            .fillMaxSize()
            .padding(horizontal = Themes.size.spaceSize36)
            .verticalScroll(state = rememberScrollState())
    ) {
        Title(
            modifier = modifier
                .padding(top = Themes.size.spaceSize24)
                .fillMaxWidth(),
            title = stringResource(id = R.string.password_generator),
            textAlign = TextAlign.Center
        )
        Column(
            modifier = modifier.weight(weight = WEIGHT_SIZE),
            verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8)) {
            Title(title = stringResource(id = R.string.include))
            Item(
                icon = R.drawable.title,
                label = R.string.unique_characters,
                isChecked = uniqueChars,
                onCheckedChange = { uniqueChars = it })
            Item(
                icon = R.drawable.lowercase,
                label = R.string.lowercase,
                isChecked = lowercase,
                onCheckedChange = { lowercase = it })
            Item(
                icon = R.drawable.uppercase,
                label = R.string.uppercase,
                isChecked = uppercase,
                onCheckedChange = { uppercase = it })
            Item(
                icon = R.drawable.numbers,
                label = R.string.numbers,
                isChecked = numbers,
                onCheckedChange = { numbers = it })
            Item(
                icon = R.drawable.hash,
                label = R.string.symbols,
                isChecked = specialChars,
                onCheckedChange = { specialChars = it })
            DropdownMenu(
                selectedValue = converterSizePassword(size = length),
                isError = false,
                items = filterFactory,
                label = stringResource(id = R.string.size_password),
                onValueChangedEvent = { length = it }
            )
            Button(
                label = R.string.generate_password,
                onClick = {
                    hash = generatePassword(
                        length = length,
                        uniqueChars = uniqueChars,
                        lowercase = lowercase,
                        uppercase = uppercase,
                        numbers = numbers,
                        specialChars = specialChars
                    )
                },
                modifier = modifier.padding(top = Themes.size.spaceSize16)
            )
            GeneratedPassword(hash = hash, modifier = modifier)
        }
        Version(modifier = Modifier.wrapContentHeight(Alignment.Bottom))
    }
}

@Composable
private fun GeneratedPassword(
    modifier: Modifier = Modifier,
    hash: String
) {
    if (hash.isNotEmpty()) {
        Title(
            title = hash,
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(top = Themes.size.spaceSize8)
                .fillMaxWidth(fraction = WEIGHT_SIZE)
        )
        Action(
            icon = R.drawable.copy,
            label = R.string.copy_password,
            textToCopy = hash,
            modifier = modifier.padding(top = Themes.size.spaceSize4)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun GeneratePasswordScreenPreview() {
    GeneratePasswordScreen()
}
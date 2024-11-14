package br.com.safe.pass.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.R
import br.com.safe.pass.components.factory.filterFactory
import br.com.safe.pass.components.ui.Button
import br.com.safe.pass.components.ui.Description
import br.com.safe.pass.components.ui.DropdownMenu
import br.com.safe.pass.components.ui.SubTitle
import br.com.safe.pass.components.ui.Title
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.components.utils.converterSizePassword
import br.com.safe.pass.components.utils.onClickable
import br.com.safe.pass.repository.generatePassword
import br.com.safe.pass.theme.Themes

@Composable
fun GeneratePasswordScreen(
    modifier: Modifier = Modifier
) {
    var hash: String by remember { mutableStateOf(value = "") }
    Column(
        modifier = modifier
            .background(color = Themes.colors.background)
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Row(modifier = modifier.padding(all = Themes.size.spaceSize16)) {
            Title(
                modifier = modifier.weight(weight = WEIGHT_SIZE),
                title = stringResource(id = R.string.password_generator),
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = modifier.padding(horizontal = Themes.size.spaceSize16),
            verticalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8),
        ) {
            var selectedValue: Int by remember { mutableIntStateOf(value = 0) }
            Title(title = stringResource(id = R.string.include))
            Item(icon = R.drawable.title, label = R.string.unique_characters)
            Item(icon = R.drawable.lowercase, label = R.string.lowercase)
            Item(icon = R.drawable.uppercase, label = R.string.uppercase)
            Item(icon = R.drawable.numbers, label = R.string.numbers)
            Item(icon = R.drawable.hash, label = R.string.symbols)
            DropdownMenu(
                selectedValue = converterSizePassword(size = selectedValue),
                isError = false,
                items = filterFactory,
                label = stringResource(id = R.string.size_password),
                onValueChangedEvent = { selectedValue = it }
            )
        }
        Column(
            modifier = modifier.padding(all = Themes.size.spaceSize16)
        ) {
            Button(
                label = R.string.generate_password,
                onClick = {
                    hash = generatePassword(length =  24, uppercase = true, numbers = true, specialChars = false)
                }
            )
            GeneratedPassword(label = hash, modifier = modifier)
            Action(icon = R.drawable.copy, label = R.string.copy_password)
        }
    }
}

@Composable
private fun GeneratedPassword(
    modifier: Modifier = Modifier,
    label: String
) {
    SubTitle(
        subTitle = label,
        textAlign = TextAlign.Center,
        modifier = modifier
            .padding(top = Themes.size.spaceSize16)
            .fillMaxWidth(fraction = WEIGHT_SIZE)
    )
}

@Composable
private fun Action(
    modifier: Modifier = Modifier,
    icon: Int,
    label: Int,
    onClick: () -> Unit = {}
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.onClickable(
            onClick = {
                onClick()
            }
        )
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = stringResource(id = label),
            modifier = modifier.size(size = Themes.size.spaceSize48)
        )
        Description(
            description = stringResource(id = label),
            modifier = modifier.weight(weight = WEIGHT_SIZE)
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun GeneratePasswordScreenPreview() {
    GeneratePasswordScreen()
}
package br.com.safe.pass.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.R
import br.com.safe.pass.components.ui.Description
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.theme.Themes

@Composable
fun Item(
    icon: Int,
    label: Int,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = stringResource(id = label))
        Description(
            description = stringResource(id = label),
            modifier = Modifier.weight(weight = WEIGHT_SIZE)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = {
                onCheckedChange(!isChecked)
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Themes.colors.background,
                checkedTrackColor = Themes.colors.primary,
                checkedBorderColor = Themes.colors.primary,
                uncheckedTrackColor = Themes.colors.background
            )
        )
    }
}

@Composable
@Preview(apiLevel = 34, showBackground = true)
fun ItemPreview() {
    Item(
        icon = R.drawable.key,
        label = R.string.generate_password,
        isChecked = true,
        onCheckedChange = {}
    )
}
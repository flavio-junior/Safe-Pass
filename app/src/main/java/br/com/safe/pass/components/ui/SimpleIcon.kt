package br.com.safe.pass.components.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import br.com.safe.pass.theme.Themes

@Composable
fun SimpleIcon(
    modifier: Modifier = Modifier,
    icon: Int,
    label: Int
) {
    Icon(
    painter = painterResource(id = icon),
    contentDescription = stringResource(id = label),
    modifier = modifier.size(size = Themes.size.spaceSize48),
    tint = Themes.colors.primary
    )
}

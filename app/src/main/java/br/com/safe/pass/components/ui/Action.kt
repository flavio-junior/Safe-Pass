package br.com.safe.pass.components.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.components.utils.onClickable
import br.com.safe.pass.theme.Themes

@Composable
fun Action(
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
        SimpleIcon(
            icon = icon,
            label = label,
            modifier = modifier.size(size = Themes.size.spaceSize24)
        )
        Description(
            description = stringResource(id = label),
            modifier = modifier.weight(weight = WEIGHT_SIZE)
        )
    }
}

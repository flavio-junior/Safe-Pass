package br.com.safe.pass.components.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.components.utils.onClickable
import br.com.safe.pass.theme.Themes

@Composable
fun Action(
    modifier: Modifier = Modifier,
    icon: Int,
    label: Int,
    textToCopy: String
) {
    val clipboardManager = LocalClipboardManager.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(space = Themes.size.spaceSize8),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.onClickable(
            onClick = {
                clipboardManager.setText(AnnotatedString(textToCopy))
            }
        )
    ) {
        SimpleIcon(
            icon = icon,
            label = label,
            modifier = modifier.size(size = Themes.size.spaceSize24)
        )
        SubTitle(
            subTitle = stringResource(id = label),
            modifier = modifier.weight(weight = WEIGHT_SIZE)
        )
    }
}

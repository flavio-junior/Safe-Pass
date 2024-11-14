package br.com.safe.pass.components.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.safe.pass.R
import br.com.safe.pass.components.utils.onBorder
import br.com.safe.pass.theme.Themes

@Composable
fun Button(
    modifier: Modifier = Modifier,
    label: Int,
    onClick: () -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .onBorder(
                onClick = onClick,
                spaceSize = Themes.size.spaceSize36,
                width = Themes.size.spaceSize2,
                color = Themes.colors.primary
            )
            .background(color = Themes.colors.success)
            .padding(all = Themes.size.spaceSize18)
            .fillMaxWidth()
    ) {
        Description(description = stringResource(id = label))
    }
}

@Composable
@Preview(showBackground = true)
private fun ButtonPreview() {
    Button(
        label = R.string.generate_password,
        onClick = {}
    )
}

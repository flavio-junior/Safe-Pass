package br.com.safe.pass.ui.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import br.com.safe.pass.R
import br.com.safe.pass.components.ui.Description
import br.com.safe.pass.components.utils.WEIGHT_SIZE
import br.com.safe.pass.theme.Themes
import br.com.safe.pass.ui.utils.VersionApp

@Composable
fun Version(
    modifier: Modifier = Modifier
) {
    val version = VersionApp(context = LocalContext.current).getVersionApp()
    Row {
        Description(
            description = stringResource(id = R.string.version, version.versionName),
            textAlign = TextAlign.Center,
            modifier = modifier
                .padding(all = Themes.size.spaceSize16)
                .weight(weight = WEIGHT_SIZE)
        )
    }
}
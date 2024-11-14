package br.com.safe.pass.components.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import br.com.safe.pass.R
import br.com.safe.pass.theme.Themes

fun Modifier.onBorder(
    onClick: () -> Unit = {},
    spaceSize: Dp,
    width: Dp,
    color: Color
): Modifier {
    return this.then(
        other = Modifier
            .border(
                width = width,
                color = color,
                shape = RoundedCornerShape(corner = CornerSize(size = spaceSize))
            )
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                enabled = true,
                onClick = onClick,
                role = Role.Button
            )
            .clip(shape = RoundedCornerShape(corner = CornerSize(size = spaceSize)))
    )
}

fun Modifier.onClickable(
    onClick: () -> Unit
): Modifier {
    return this.then(
        other = Modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            enabled = true,
            onClick = onClick,
            role = Role.Button
        )
    )
}

@Composable
fun colorTheme(error: Boolean): TextFieldColors {
    return if (error) {
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Themes.colors.error,
            unfocusedBorderColor = Themes.colors.error,
            cursorColor = Themes.colors.error
        )
    } else {
        OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Themes.colors.primary,
            unfocusedBorderColor = Themes.colors.primary,
            cursorColor = Themes.colors.primary
        )
    }
}

const val WEIGHT_SIZE = 1f

@Composable
fun converterSizePassword(size: Int): String {
    return when (size) {
        0 -> stringResource(id = R.string.empty_size)
        8 -> stringResource(id = R.string.eight_characters)
        16 -> stringResource(id = R.string.sixteen_characters)
        24 -> stringResource(id = R.string.twenty_four_characters)
        else -> stringResource(id = R.string.empty_size)
    }
}

fun converterSizePasswordToNumber(value: Int): Int {
    return when (value) {
        R.string.eight_characters -> 8
        R.string.sixteen_characters -> 16
        R.string.twenty_four_characters -> 24
        else -> 0
    }
}

package br.com.safe.pass.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import br.com.safe.pass.R

private val fontSize = FontSize

data class Typography(
    val color: Color = Color.Black,
    val textAlign: TextAlign = TextAlign.Start,
    val typeFont: TypeFont? = null
) {

    val title: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize32,
        fontWeight = FontWeight.SemiBold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val subTitle: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize24,
        fontWeight = FontWeight.Medium,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_MEDIUM),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val description: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize20,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_REGULAR),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val simpleText: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize16,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_REGULAR),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val infoText: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize14,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val smallText: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize12,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )

    val miniText: TextStyle = TextStyle(
        color = color,
        fontSize = fontSize.fontSize8,
        fontWeight = FontWeight.Bold,
        textAlign = textAlign,
        lineHeight = TextUnit.Unspecified,
        fontFamily = selectFontFamily(typeFont = typeFont ?: TypeFont.ONEST_BOLD),
        textDecoration = TextDecoration.None,
        fontStyle = FontStyle.Normal,
        letterSpacing = TextUnit.Unspecified
    )
}

val LocalTypography = staticCompositionLocalOf {
    Typography()
}

private fun selectFontFamily(typeFont: TypeFont): FontFamily {
    return when (typeFont) {
        TypeFont.ONEST_BOLD -> FontFamily(Font(R.font.onest_bold))
        TypeFont.ONEST_MEDIUM -> FontFamily(Font(R.font.onest_medium))
        TypeFont.ONEST_REGULAR -> FontFamily(Font(R.font.onest_regular))
    }
}

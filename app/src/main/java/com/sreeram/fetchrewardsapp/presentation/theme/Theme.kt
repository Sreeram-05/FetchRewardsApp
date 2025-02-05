package com.sreeram.fetchrewardsapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF009688),
    primaryContainer = Color(0xFF80CBC4),
    secondary = Color(0xFF00796B),
    secondaryContainer = Color(0xFFB2DFDB),
    background = Color(0xFFFFFFFF),
    surface = Color(0xFFFFFFFF),
    onPrimary = Color(0xFFFFFFFF),
    onSecondary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF000000),
    onSurface = Color(0xFF000000),
    error = Color(0xFFB00020),
)

private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFF009688),
    primaryContainer = Color(0xFF004D40),
    secondary = Color(0xFF80CBC4),
    secondaryContainer = Color(0xFF00796B),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    onPrimary = Color(0xFF000000),
    onSecondary = Color(0xFF000000),
    onBackground = Color(0xFFFFFFFF),
    onSurface = Color(0xFFFFFFFF),
    error = Color(0xFFCF6679),
)


@Composable
fun FetchRewardsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorPalette
        else -> LightColorPalette
    }
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette


    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )

}
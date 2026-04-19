package com.example.applibrary.ui.theme

import android.app.Activity
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

private val LightColorScheme = lightColorScheme(
    primary = HeaderGreen,
    onPrimary = Color.White,
    secondary = AccentYellow,
    onSecondary = Color.Black,
    tertiary = HeaderGreenLight,
    onTertiary = Color.White,
    background = BackgroundLight,
    onBackground = Color.Black,
    surface = BottomBarBackground,
    onSurface = Color.Black
)
private val DarkColorScheme = darkColorScheme(
    primary = HeaderGreenDark,
    onPrimary = Color.White,
    secondary = AccentYellowDarkMode,
    onSecondary = Color.Black,
    tertiary = HeaderGreenDarkLight,
    onTertiary = Color.White,
    background = BackgroundDark,
    onBackground = Color.White,
    surface = BottomBarBackgroundDark,
    onSurface = Color.White
)


@Composable
fun AppLibraryTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
       darkTheme -> DarkColorScheme
        else -> LightColorScheme
        }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}



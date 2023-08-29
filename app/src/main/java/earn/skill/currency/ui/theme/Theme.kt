package earn.skill.currency.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
        primary = Purple80,
        secondary = PurpleGrey80,
        tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
        primary = Purple40,
        secondary = PurpleGrey40,
        tertiary = Pink40

        /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)



private val LightColors = lightColorScheme(
    primary = Palette.md_theme_light_primary,
    onPrimary = Palette.md_theme_light_onPrimary,
    primaryContainer = Palette.md_theme_light_primaryContainer,
    onPrimaryContainer = Palette.md_theme_light_onPrimaryContainer,
    secondary = Palette.md_theme_light_secondary,
    onSecondary = Palette.md_theme_light_onSecondary,
    secondaryContainer = Palette.md_theme_light_secondaryContainer,
    onSecondaryContainer = Palette.md_theme_light_onSecondaryContainer,
    tertiary = Palette.md_theme_light_tertiary,
    onTertiary = Palette.md_theme_light_onTertiary,
    tertiaryContainer = Palette.md_theme_light_tertiaryContainer,
    onTertiaryContainer = Palette.md_theme_light_onTertiaryContainer,
    error = Palette.md_theme_light_error,
    errorContainer = Palette.md_theme_light_errorContainer,
    onError = Palette.md_theme_light_onError,
    onErrorContainer = Palette.md_theme_light_onErrorContainer,
    background = Palette.md_theme_light_background,
    onBackground = Palette.md_theme_light_onBackground,
    surface = Palette.md_theme_light_surface,
    onSurface = Palette.md_theme_light_onSurface,
    surfaceVariant = Palette.md_theme_light_surfaceVariant,
    onSurfaceVariant = Palette.md_theme_light_onSurfaceVariant,
    outline = Palette.md_theme_light_outline,
    inverseOnSurface = Palette.md_theme_light_inverseOnSurface,
    inverseSurface = Palette.md_theme_light_inverseSurface,
    inversePrimary = Palette.md_theme_light_inversePrimary,
    surfaceTint = Palette.md_theme_light_surfaceTint,
    outlineVariant = Palette.md_theme_light_outlineVariant,
    scrim = Palette.md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = Palette.md_theme_dark_primary,
    onPrimary = Palette.md_theme_dark_onPrimary,
    primaryContainer = Palette.md_theme_dark_primaryContainer,
    onPrimaryContainer = Palette.md_theme_dark_onPrimaryContainer,
    secondary = Palette.md_theme_dark_secondary,
    onSecondary = Palette.md_theme_dark_onSecondary,
    secondaryContainer = Palette.md_theme_dark_secondaryContainer,
    onSecondaryContainer = Palette.md_theme_dark_onSecondaryContainer,
    tertiary = Palette.md_theme_dark_tertiary,
    onTertiary = Palette.md_theme_dark_onTertiary,
    tertiaryContainer = Palette.md_theme_dark_tertiaryContainer,
    onTertiaryContainer = Palette.md_theme_dark_onTertiaryContainer,
    error = Palette.md_theme_dark_error,
    errorContainer = Palette.md_theme_dark_errorContainer,
    onError = Palette.md_theme_dark_onError,
    onErrorContainer = Palette.md_theme_dark_onErrorContainer,
    background = Palette.md_theme_dark_background,
    onBackground = Palette.md_theme_dark_onBackground,
    surface = Palette.md_theme_dark_surface,
    onSurface = Palette.md_theme_dark_onSurface,
    surfaceVariant = Palette.md_theme_dark_surfaceVariant,
    onSurfaceVariant = Palette.md_theme_dark_onSurfaceVariant,
    outline = Palette.md_theme_dark_outline,
    inverseOnSurface = Palette.md_theme_dark_inverseOnSurface,
    inverseSurface = Palette.md_theme_dark_inverseSurface,
    inversePrimary = Palette.md_theme_dark_inversePrimary,
    surfaceTint = Palette.md_theme_dark_surfaceTint,
    outlineVariant = Palette.md_theme_dark_outlineVariant,
    scrim = Palette.md_theme_dark_scrim,
)

@Composable
fun SkillCurrencyTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}
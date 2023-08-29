package earn.skill.currency.presenation.ui.adjustSkills

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import earn.skill.currency.presenation.ui.vertical

@Composable
fun SkillCard(
    text: String,
    isCurrent: Boolean,
    progressState: MutableState<Float>
) {
    val progress by progressState
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 10f),
        animationSpec = tween(
            durationMillis = 500,
            easing = LinearOutSlowInEasing,
            delayMillis = 0
        ), label = ""
    )

    Card(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxHeight()
            .alpha(if (isCurrent) 1f else 0.3f)
            .offset(y = if (isCurrent) 0.dp else 10.dp), elevation = CardDefaults.cardElevation(
            if (isCurrent) 80.dp else 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary
        ),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.tertiary)
                .drawWithContent {
                    drawRect(
                        color = Color.Green,
                        size = Size(size.width, size.height * (animatedProgress / 10f)),
                        topLeft = Offset(0f, size.height * (1f - animatedProgress / 10f))
                    )
                    drawContent()
                }
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = text,
                    modifier = Modifier
                        .vertical()
                        .rotate(-90f),
                    color = MaterialTheme.colorScheme.tertiaryContainer,
                    fontWeight = FontWeight.Bold
                )

            }
        }
    }
}

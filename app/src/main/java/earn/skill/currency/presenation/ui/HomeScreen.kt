import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import earn.skill.currency.navigation.Screens
import earn.skill.currency.ui.theme.BlueGreen

@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row {


                val compnotify by rememberLottieComposition(
                    spec = LottieCompositionSpec.Asset("blockchain2.json")
                )
                val progress by animateLottieCompositionAsState(compnotify)
                LottieAnimation(
                    composition = compnotify,
                    iterations = Int.MAX_VALUE,
                    isPlaying = true,
                    contentScale = ContentScale.Crop,
                    speed = 1.45f,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(45.dp)
                        .padding(top = 200.dp)
                )
            }

            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 300.dp)
            ) {
                TextBig(text = "Explore Skill Currency" , color = BlueGreen)
            }

            Spacer(modifier = Modifier.height(40.dp))
            TextSmall(text = "Upskilling to leverage job" , color = Color.White )
            TextSmall(text = "opportunities globally" , color = Color.White )
            Spacer(modifier = Modifier.height(15.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 30.dp, bottom = 30.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomIcon(
                percentage = 0.166f,
                onClick = {
                    navController.navigate(Screens.ExpertiseAnimation.route)
                }
            )
        }

    }
}


@Composable
fun TextBig(text: String, color: Color) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text,
            fontSize = 30.sp,
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier
                .padding(
                    top = 2.dp,
                    end = 20.dp
                )
            , color = color
        )
    }
}

@Composable
fun TextSmall(text: String, color: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = color,
            modifier = Modifier
                .padding(
                    start = 25.dp,
                    end = 25.dp
                )
        )
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    icon: ImageVector,
    radius: Dp = 50.dp,
    color: Color = Color.LightGray,
    strokeWidth: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay: Int = 0,
    onClick: () -> Unit = {}
) {

    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercentage = animateFloatAsState(
        targetValue = if (animationPlayed) percentage else 0f,
        animationSpec = tween(
            durationMillis = animDelay
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Box(
        modifier = Modifier
            .size(radius * 2f)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.size(radius * 2f)) {
            drawArc(
                color = color,
                -90f,
                360 * curPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }

        Icon(
            imageVector = icon,
            contentDescription = "Progress Icon",
            tint = Color.White,
            modifier = Modifier.fillMaxSize().clickable {
                onClick()
            }

        )
    }
}


@Composable
fun BottomIcon(percentage: Float, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .padding(
                start = 270.dp,
                end = 20.dp,
                top = 20.dp,
                bottom = 20.dp
            ),
        Alignment.BottomEnd
    ) {
        Column {
            CircularProgressBar(
                percentage = percentage,
                icon = Icons.Default.ArrowCircleRight,
                onClick= onClick
            )

        }
    }
}
package earn.skill.currency.presenation.ui

import BottomIcon
import TextSmall
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import earn.skill.currency.navigation.Screens
import earn.skill.currency.ui.theme.BlueGreen
import earn.skill.currency.ui.theme.Orange
import earn.skill.currency.ui.theme.Purple40

@Composable
fun Start(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Start Learning",
                    textAlign = TextAlign.Center,
                    fontSize = 22.sp,
                    color= Orange,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(top = 50.dp)
                )
            }

            Divider(
                color = Color.White,
                thickness = 1.dp,
                modifier = Modifier.padding(top = 15.dp, start = 80.dp, end = 80.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Push",
                    textAlign = TextAlign.Center,
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(top = 15.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Yourself",
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Purple40,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(bottom = 15.dp, top = 2.dp)

                )
            }


            TextSmall(text = "Need help to improve ", color = Color.White)
            TextSmall(text = "your skills?" , color = Color.White)


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {
                        navController.navigate(Screens.CardWallet.route)
                    },
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .width(170.dp)
                        .height(50.dp),

                    ) {
                    Text(text = "Let's Start")
                }
            }
            val compnotify by rememberLottieComposition(
                spec = LottieCompositionSpec.Asset("study.json")
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
                    .padding(top = 180.dp),
            )


        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp , end = 5.dp , bottom = 30.dp, start = 60.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomIcon(
                percentage = 0.83f,
                onClick = {
                    navController.navigate(Screens.CardWallet.route)
                }
            )
        }
    }
}
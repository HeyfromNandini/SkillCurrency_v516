package earn.skill.currency.presenation.ui

import BottomIcon
import TextBig
import TextSmall
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import earn.skill.currency.R
import earn.skill.currency.navigation.Screens
import earn.skill.currency.ui.theme.Purple40
import earn.skill.currency.ui.theme.PurpleGrey40
import earn.skill.currency.ui.theme.PurpleGrey80
import earn.skill.currency.ui.theme.PurpleLight

@Composable
fun ChooseSkills(navController: NavHostController) {


    Box(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.fillMaxSize()) {

            Spacer(modifier = Modifier.height(30.dp))
            TextBig(text = "Choose a way to", color = Color.White)
            TextBig(text = "study information", color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))
            TextSmall(text = "Choose ways that makes it easier for you to gain knowledge" , color= PurpleGrey80)


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 20.dp)
            ) {

                Column(modifier = Modifier) {

                    CardSmall(lottie = "audio.json", text = "AUDIO")

                    Spacer(modifier = Modifier.height(15.dp))
                    CardBig(lottie = "video2.json", text = "VIDEO")
                }

                Spacer(modifier = Modifier.width(15.dp))

                Column(modifier = Modifier) {
                    CardBig(lottie = "mentor2.json", text = "MENTOR")

                    Spacer(modifier = Modifier.height(15.dp))
                    CardSmall(lottie = "articles.json", text = "ARTICLES")

                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp , end = 5.dp , bottom = 30.dp, start = 60.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomIcon(
                percentage = 0.66f,
                onClick = {
                    navController.navigate(Screens.Start.route)
                }
            )
        }
    }
}

@Composable
fun CardBig(lottie: String,text: String ,contentScale: ContentScale = ContentScale.Crop) {

    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .height(200.dp)
            .width(150.dp)
    ) {

        Box(modifier = Modifier.padding(start = 20.dp)){
            Text(text = text ,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium ,
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
        }

        val compnotify by rememberLottieComposition(
            spec = LottieCompositionSpec.Asset(lottie)
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
                .padding(top = 20.dp, start = 15.dp, end = 15.dp, bottom = 15.dp)
        )
    }
}

@Composable
fun CardSmall(lottie: String, text: String,contentScale: ContentScale = ContentScale.Crop) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .height(170.dp)
            .width(150.dp),


    ) {
Box(modifier = Modifier.padding(start = 20.dp)){
    Text(text = text ,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium ,
        modifier = Modifier.padding(top = 10.dp, bottom = 10.dp))
}

        val compnotify by rememberLottieComposition(
        spec = LottieCompositionSpec.Asset(lottie)
    )
        val progress by animateLottieCompositionAsState(compnotify)
        LottieAnimation(
            composition = compnotify,
            iterations = Int.MAX_VALUE,
            isPlaying = true,
            contentScale = ContentScale.Crop,
            speed = 1.45f,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp, start = 15.dp, end = 15.dp, bottom = 30.dp)

        )

    }
}
        
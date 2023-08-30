import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun HomeScreen() {

    Column (modifier = Modifier.fillMaxSize()){

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
                    .padding(top = 180.dp)
            )
        }

        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 300.dp)
        ) {
            TextBig(text = "Explore your New")
        }
        TextBig(text = "SKill Today")

        Spacer(modifier = Modifier.height(20.dp))
        TextSmall(text = "New Skills diversify your Job Options & helps you with to keep up with the Ever-changing world")
        Spacer(modifier = Modifier.height(15.dp))

        BottomIcon()

    }
}


@Composable
fun TextBig(text:String) {

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
        )
    }
}

@Composable
fun TextSmall(text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            color = Color.White,
            modifier = Modifier
                .padding(
                    start = 20.dp,
                    end = 25.dp
                )
        )
    }
}

@Composable
fun BottomIcon() {
    Box(modifier = Modifier
        .padding(start = 270.dp,
            end=10.dp,
            top = 40.dp),
        Alignment.BottomEnd) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .size(50.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowCircleRight,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()

                )

            }
        }
    }
}

package earn.skill.currency

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.umut.soysal.compose.creditcardview.component.CreditCardView
import com.umut.soysal.compose.creditcardview.model.CreditCard
import earn.skill.currency.presenation.ui.ChooseSkills
import earn.skill.currency.presenation.ui.Start
import earn.skill.currency.ui.theme.SkillCurrencyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SkillCurrencyTheme {

                val systemUiController = rememberSystemUiController()
                SideEffect {
                    // set transparent color so that our image is visible
                    // behind the status bar
                    systemUiController.setStatusBarColor(color = Color(0xFF1C1B1F))
                    systemUiController.setNavigationBarColor(
                        color = Color(0xFF1C1B1F)
                    )
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {

//                    Start()
//                    ChooseSkills()
//                    HomeScreen()
//                    CardWallet()
//                    ChooseYourSkills()
//                    ExpertiseAnimation()
                }
            }
        }
    }
}

@OptIn(ExperimentalUnitApi::class)
@Composable
fun CardWallet(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp)
    ) {
        val creditCard = CreditCard(
            creditCardNumber = "3437 **** **** *123",
            cardBackgroundColor = MaterialTheme.colorScheme.surface.copy(0.95f).toArgb(),
            textColor = MaterialTheme.colorScheme.surfaceTint.toArgb(),
            isNfc = true,
            expiration = "23/10",
            holderName = "Kailash Sharma",
            bankName = "HDFC BANK LTD.",
            cardType = "VISA"
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Transparent
            ),
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            CreditCardView(creditCard = creditCard)
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFE92B)
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Send,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Transfer",
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF8BC34A)
                )
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Filled.Payment,
                        contentDescription = null,
                        modifier = Modifier.size(15.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Request",
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }

        Spacer(modifier = Modifier.height(35.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Transactions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Icon(
                imageVector = Icons.Filled.MoreHoriz,
                contentDescription = null
            )
        }

        Spacer(modifier = Modifier.height(35.dp))

        RepeatedCard(
            image = R.drawable.vistara,
            title = "Vistara Premium",
            desc = "3 Dec 2020",
            price = "-2000 Rs"
        )

        Spacer(modifier = Modifier.height(10.dp))

        RepeatedCard(
            image = R.drawable.airindia,
            title = "Air India Business",
            desc = "23 Jan 2021",
            price = "+100 Rs",
            isRed = false
        )

        Spacer(modifier = Modifier.height(10.dp))

        RepeatedCard(
            image = R.drawable.indigo,
            title = "Indigo Premium",
            desc = "19 Mar 2021",
            price = "-1500 Rs",
            isRed = true
        )


    }
}

@Composable
fun RepeatedCard(
    image: Int,
    title: String,
    desc: String,
    price: String,
    isRed: Boolean = true
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface.copy(0.95f)
        ),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = image),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .size(60.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = title,
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = desc,
                    color = MaterialTheme.colorScheme.onSurfaceVariant.copy(0.4f),
                    fontSize = 11.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 15.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Text(text = price, color = if (isRed) Color.Red else Color.Green)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
    }
}









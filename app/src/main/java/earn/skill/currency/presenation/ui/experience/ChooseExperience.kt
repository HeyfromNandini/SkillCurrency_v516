package earn.skill.currency.presenation.ui.experience

import BottomIcon
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import earn.skill.currency.R
import earn.skill.currency.navigation.Screens
import earn.skill.currency.presenation.ui.ComposableRiveAnimationView


@Composable
fun ExpertiseAnimation(navController: NavHostController) {
    var value by remember { mutableFloatStateOf(0f) }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "What's your Experience 🤔",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 25.sp
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 20.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Let's get started soon 😅",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 12.sp
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    ComposableRiveAnimationView(
                        animation = R.raw.skills,
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.background)
                            .size(400.dp)
                    ) { view ->
                        view.setNumberState(
                            "skill-controller",
                            "level",
                            value
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            onClick = {
                                value = 0f
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 7.dp),
                        ) {
                            Text(
                                text = "Beginner 👶",
                                fontSize = 15.sp
                            )
                        }

                        OutlinedButton(
                            onClick = {
                                value = 1f
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 7.dp)
                        ) {
                            Text(
                                text = "Inter-mediate 👨",
                                fontSize = 14.sp,
                            )
                        }

                        OutlinedButton(
                            onClick = {
                                value = 2f
                            },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 7.dp)
                        ) {
                            Text(
                                text = "Advanced👴",
                                fontSize = 14.sp
                            )
                        }

                    }

                }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 30.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomIcon(
                percentage = 0.34f,
                onClick = {
                    navController.navigate(Screens.ChooseYourSkills.route)
                }
            )
        }
    }
}

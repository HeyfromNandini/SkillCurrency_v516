package earn.skill.currency.presenation.ui.adjustSkills

import BottomIcon
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import earn.skill.currency.navigation.Screens
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ChooseYourSkills(navController: NavHostController) {
    val skillList = listOf("Java", "Python", "C++", "Cloud", "DBA", "CyberSecurity")
    val pagerState = rememberPagerState(
        initialPage = 0, initialPageOffsetFraction = 0f
    ) { 5 }
    val coroutineScope = rememberCoroutineScope()
    val progressList = remember { mutableStateListOf(*Array(skillList.size) { mutableStateOf(3f) }) }


    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, start = 10.dp),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    text = "Adjust your skills",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 25.sp
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 25.dp,
                        start = 10.dp,
                        end = 10.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage - 1)
                        }
                    }
                )

                Text(
                    text = "${progressList[pagerState.currentPage].value}",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 25.sp
                )

                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.clickable {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                )
            }

            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(150.dp),
                userScrollEnabled = true
            ) { page ->
                SkillCard(
                    text = skillList[page],
                    isCurrent = page == pagerState.currentPage,
                    progressState = progressList[page]
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 15.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 25.dp,
                        start = 20.dp,
                        end = 20.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Filled.Remove,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.clickable {
                        if (progressList[pagerState.currentPage].value > 0f)
                            progressList[pagerState.currentPage].value--
                    }
                )

                Text(
                    text = "Keep Rating",
                    color = MaterialTheme.colorScheme.surfaceTint,
                    fontSize = 25.sp
                )

                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.clickable {
                        if (progressList[pagerState.currentPage].value < 10f)
                            progressList[pagerState.currentPage].value++
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(end = 30.dp, bottom = 30.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            BottomIcon(
                percentage = 0.5f,
                onClick = {
                    navController.navigate(Screens.ChooseSkills.route)
                }
            )
        }
    }
}
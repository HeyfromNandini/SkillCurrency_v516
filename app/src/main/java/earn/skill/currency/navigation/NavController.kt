package earn.skill.currency.navigation

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import earn.skill.currency.CardWallet
import earn.skill.currency.presenation.ui.ChooseSkills
import earn.skill.currency.presenation.ui.Start
import earn.skill.currency.presenation.ui.adjustSkills.ChooseYourSkills
import earn.skill.currency.presenation.ui.experience.ExpertiseAnimation


@Composable
fun MainNavController() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screens.HomeScreen.route,
        enterTransition = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(300),
            )
        },
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popEnterTransition = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(300),
            )
        },
        popExitTransition = {
            slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(300),
            )
        },

        ) {
        composable(Screens.CardWallet.route) {
           CardWallet(navController = navHostController)
        }

        composable(Screens.ChooseSkills.route) {
            ChooseSkills(navHostController)
        }

        composable(Screens.ChooseYourSkills.route) {
           ChooseYourSkills(navController = navHostController)
        }

        composable(Screens.Start.route) {
           Start(navHostController)
        }

        composable(Screens.ExpertiseAnimation.route) {
           ExpertiseAnimation(navHostController)
        }

        composable(Screens.HomeScreen.route){
            HomeScreen(navController = navHostController)
        }



    }
}
package earn.skill.currency.navigation

sealed class Screens(val route: String) {
    data object HomeScreen : Screens("homescreen")
    data object ChooseSkills : Screens("chooseskills")
    data object Start : Screens("start")
    data object CardWallet : Screens("cardwallet")
    data object ChooseYourSkills : Screens("chooseyourskills")
    data object ExpertiseAnimation : Screens("expertiseanimation")

}



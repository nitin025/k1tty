package dev.nitin.k1tty.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dev.nitin.k1tty.data.repository.DummyCatData
import dev.nitin.k1tty.navigation.Page

@Composable
fun K1ttyRoot(toggleTheme: () -> Unit) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Page.Home.route) {
        composable(Page.Home.route) {
            Home(
                navController = navController,
                catsList = DummyCatData.catsList,
                recommendedCatsList = DummyCatData.recommendedCatsList,
                toggleTheme = toggleTheme
            )
        }
        composable(
            "${Page.Details.route}/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { Details(navController = navController, id = it.arguments?.getInt("id") ?: 0) }
    }
}
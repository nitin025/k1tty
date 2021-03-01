package dev.nitin.k1tty.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import dev.nitin.k1tty.data.model.Cat
import androidx.navigation.NavHostController
import dev.nitin.k1tty.widgets.AppBar

@Composable
fun Home(navController: NavHostController, catsList: List<Cat>,recommendedCatsList: List<Cat>, toggleTheme: () -> Unit) {
    
    LazyColumn {
        item {
            AppBar {
                toggleTheme()
            }
        }
    }
}
package dev.nitin.k1tty.navigation

import androidx.annotation.StringRes
import dev.nitin.k1tty.R

sealed class Page(val route: String, @StringRes val resourceId: Int) {
    object Home : Page("home", R.string.home)
    object Details : Page("details", R.string.details)
}
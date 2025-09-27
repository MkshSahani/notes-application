package com.r2b.mynotes.constants

sealed class Screens(val route: String) {

    object HomeScreen : Screens("home")

}
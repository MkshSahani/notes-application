package com.r2b.mynotes.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.r2b.mynotes.constants.Screens
import com.r2b.mynotes.screens.HomeScreen


@Composable
fun NoteApplicationNavigation(navHostController: NavHostController) {

    NavHost(navHostController, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen()
        }
    }

}
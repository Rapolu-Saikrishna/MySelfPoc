package com.selfpoc.mypocwork.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.selfpoc.mypocwork.presentation.login.LoginScreen
import com.selfpoc.mypocwork.presentation.registration.RegisterScreen
import com.selfpoc.mypocwork.presentation.newslist.NewsListScreen
import com.selfpoc.mypocwork.presentation.newsdetail.NewsDetailScreen

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route,
        modifier = modifier
    ) {
        composable(Screen.Login.route) { LoginScreen(navController) }
        composable(Screen.Register.route) { RegisterScreen(navController) }
        composable(Screen.NewsList.route) { NewsListScreen(navController) }
        composable(Screen.NewsDetail.route) { NewsDetailScreen() }
    }
}

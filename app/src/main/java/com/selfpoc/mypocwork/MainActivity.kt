package com.selfpoc.mypocwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.selfpoc.mypocwork.presentation.login.LoginScreen
import com.selfpoc.mypocwork.presentation.navigation.Screen
import com.selfpoc.mypocwork.presentation.newsdetail.NewsDetailScreen
import com.selfpoc.mypocwork.presentation.newslist.NewsListScreen
import com.selfpoc.mypocwork.presentation.registration.RegisterScreen
import com.selfpoc.mypocwork.ui.theme.MyNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNewsAppTheme  {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Login.route) {
                    composable(Screen.Login.route) {
                        LoginScreen(navController)
                    }
                    composable(Screen.Register.route) {
                        RegisterScreen(navController)
                    }
                    composable(Screen.NewsList.route) {
                        NewsListScreen(navController)
                    }
                    composable(Screen.NewsDetail.route) {
                        NewsDetailScreen()
                    }
                }
            }
        }
    }
}

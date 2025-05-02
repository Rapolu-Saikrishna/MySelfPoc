package com.selfpoc.mypocwork.presentation.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object NewsList : Screen("news_list")
    object NewsDetail : Screen("news_detail/{id}") {
        fun createRoute(id: String) = "news_detail/$id"
    }
}
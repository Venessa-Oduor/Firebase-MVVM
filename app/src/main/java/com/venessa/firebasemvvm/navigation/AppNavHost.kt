package com.venessa.firebasemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.venessa.firebasemvvm.ui.theme.screens.Products.AddProductsScreen
import com.venessa.firebasemvvm.ui.theme.screens.Products.UpdateProductsScreen
import com.venessa.firebasemvvm.ui.theme.screens.Products.ViewProductsScreen
import com.venessa.firebasemvvm.ui.theme.screens.Products.ViewUploadsScreen
import com.venessa.firebasemvvm.ui.theme.screens.home.HomeScreen
import com.venessa.firebasemvvm.ui.theme.screens.login.LoginScreen
import com.venessa.firebasemvvm.ui.theme.screens.register.RegisterScreen
import com.venessa.firebasemvvm.ui.theme.screens.splash.SplashScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier, navController: NavHostController= rememberNavController(), startDestination:String= ROUTE_SPLASH) {
    NavHost(navController=navController,modifier=Modifier,startDestination=startDestination){
        composable(ROUTE_SPLASH){
            SplashScreen(navController)
        }
        composable(ROUTE_HOME){
            HomeScreen(navController)
        }
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_ADD_PRODUCT) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCT +"/{id}") {passedData ->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_PRODUCT) {
            ViewProductsScreen(navController)
        }
        composable(ROUTE_VIEW_UPLOAD) {
            ViewUploadsScreen(navController)
        }

    }
}







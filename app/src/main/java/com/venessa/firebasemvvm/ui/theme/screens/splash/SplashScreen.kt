package com.venessa.firebasemvvm.ui.theme.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.venessa.firebasemvvm.R
import com.venessa.firebasemvvm.navigation.ROUTE_HOME
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    //Delay to stimulate splash screen duration
    LaunchedEffect(Unit) {
        delay(2000) //2 seconds delay
        navController.navigate(ROUTE_HOME)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.nature),
            contentDescription ="splash logo" ,
            modifier = Modifier.size(200.dp))
    }
}
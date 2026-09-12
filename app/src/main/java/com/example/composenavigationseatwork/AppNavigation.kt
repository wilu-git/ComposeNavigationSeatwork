package com.example.composenavigationseatwork

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {

        composable("home") {

            HomeScreen(
                onViewDetails = { studentId, studentName, studentCourse ->

                    navController.navigate(
                        "details/" +
                                "${Uri.encode(studentId)}/" +
                                "${Uri.encode(studentName)}/" +
                                "${Uri.encode(studentCourse)}"
                    )
                }
            )
        }


        composable(
            route = "details/{studentId}/{studentName}/{studentCourse}",
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.StringType
                },
                navArgument("studentName") {
                    type = NavType.StringType
                },
                navArgument("studentCourse") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->

            val studentId =
                backStackEntry.arguments?.getString("studentId") ?: ""

            val studentName =
                backStackEntry.arguments?.getString("studentName") ?: ""

            val studentCourse =
                backStackEntry.arguments?.getString("studentCourse") ?: ""

            DetailsScreen(
                studentId = studentId,
                studentName = studentName,
                studentCourse = studentCourse,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
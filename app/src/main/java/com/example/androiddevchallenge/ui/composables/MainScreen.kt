package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.repo.DogRepo

@Composable
fun MainScreen(dogs: List<Dog>) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "doglist") {
        composable("doglist") {
            DogAppBarScaffold(stringResource(R.string.main_title), hasFab = false) {
                DogsList(dogs, navController, modifier = Modifier.fillMaxWidth())
            }
        }
        composable(
            "dogdetails/{id}",
            arguments = listOf(
                navArgument("{id}") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            DogAppBarScaffold(stringResource(R.string.dog_details_title), navController, hasFab = true) {
                DogDetails(backStackEntry.arguments?.getString("id"))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(dogs = DogRepo().getDogs())
}

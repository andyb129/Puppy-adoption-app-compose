/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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

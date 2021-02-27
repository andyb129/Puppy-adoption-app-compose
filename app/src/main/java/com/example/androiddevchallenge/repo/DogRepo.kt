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
package com.example.androiddevchallenge.repo

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Breed
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.Sex

class DogRepo {

    fun getDogs() =
        listOf(
            Dog("1", "Colin", Breed.Collie, 2, Sex.Male, "Great little fella", R.drawable.bordercollie),
            Dog("2", "Bobby", Breed.Bulldog, 3, Sex.Male, "Tough but friendly", R.drawable.bulldog),
            Dog("3", "Cathy", Breed.Chihuahua, 1, Sex.Female, "Sweet and likes cuddles", R.drawable.chihuahua),
            Dog("4", "Dave", Breed.Dachshund, 4, Sex.Male, "Very friendly and energetic", R.drawable.dachshund),
            Dog("5", "Shadow", Breed.Husky, 2, Sex.Male, "Energetic and loyal", R.drawable.siberian_husky)
        )

    fun getDogById(id: String?) = getDogs().find { it.id == id }
}

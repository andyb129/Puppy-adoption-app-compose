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

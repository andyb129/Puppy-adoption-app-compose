package com.example.androiddevchallenge.model

data class Dog (
    val id: String,
    val name: String,
    val breed: Breed,
    val age: Int,
    val sex: Sex,
    val notes: String,
    val imageResource: Int
)

enum class Breed {
    Collie,
    Bulldog,
    Chihuahua,
    Dachshund,
    Husky
}

enum class Sex {
    Male,
    Female
}

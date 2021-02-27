package com.example.androiddevchallenge.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.repo.DogRepo

@Composable
fun DogsList(dogs: List<Dog>, navController: NavController?, modifier: Modifier = Modifier) {
    Box(modifier) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()) {
            items(dogs) { dog ->
                DogListItem( dog, navController)
            }
        }
    }
}

@Composable
fun DogListItem(dog: Dog, navController: NavController?) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .clickable {
                navController?.navigate("dogdetails/${dog.id}")
            }
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(Modifier.width(16.dp))
        Image(
            painterResource(id = dog.imageResource),
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip((CircleShape))
                .size(72.dp)
                .background(color = Color.Gray)
        )
        Spacer(Modifier.width(24.dp))
        Column(Modifier.padding(16.dp)) {
            Text(dog.name, style = MaterialTheme.typography.h6)
            Spacer(Modifier.height(8.dp))
            Text("Breed: " + dog.breed.name, style = MaterialTheme.typography.subtitle1)
            Spacer(Modifier.height(8.dp))
        }
    }
    Divider(color = Color.LightGray)
}

@Preview(showBackground = true)
@Composable
fun DogListPreview() {
    DogsList(DogRepo().getDogs(), null)
}

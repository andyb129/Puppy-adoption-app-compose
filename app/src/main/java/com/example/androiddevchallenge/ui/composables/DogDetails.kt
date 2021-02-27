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

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import com.example.androiddevchallenge.repo.DogRepo

@Composable
fun DogDetails(id: String?) {
    val dog = DogRepo().getDogById(id)

    if (dog != null) {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(32.dp).fillMaxWidth())
            Row {
                Image(
                    painterResource(id = dog.imageResource ?: 0),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .clip((CircleShape))
                        .size(166.dp)
                        .background(color = Color.Gray)
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = dog.name,
                    style = MaterialTheme.typography.h4.copy(MaterialTheme.colors.secondary)
                )
                TextDetails("Breed : " + dog.breed)
                TextDetails("Age : " + dog.age)
                TextDetails("Sex : " + dog.sex)
                TextDetails("Notes : " + dog.notes)
            }
        }
    } else {
        Column(Modifier.background(MaterialTheme.colors.background)) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
            }
        }
    }
}

@Composable
fun TextDetails(text: String) {
    Text(
        modifier = Modifier.padding(8.dp),
        text = text,
        style = MaterialTheme.typography.subtitle1
    )
}

@Preview(showBackground = true)
@Composable
fun DogDetailsPreview() {
    DogRepo().getDogById("1")?.let { DogDetails("1") }
}

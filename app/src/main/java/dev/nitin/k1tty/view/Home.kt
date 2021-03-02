package dev.nitin.k1tty.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import dev.nitin.k1tty.R
import dev.nitin.k1tty.data.model.Cat
import dev.nitin.k1tty.ui.theme.typography
import dev.nitin.k1tty.widgets.AppBar

@Composable
fun Home(
    navController: NavHostController,
    catsList: List<Cat>,
    recommendedCatsList: List<Cat>,
    toggleTheme: () -> Unit
) {

    LazyColumn {
        item {
            AppBar(onToggle = {
                toggleTheme()
            })
        }
        item {
            Column {
                Text(
                    text = "Search For a Pet",
                    modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                    color = MaterialTheme.colors.onSurface,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(12.dp))
                val searchIcon: Painter = painterResource(id = R.drawable.ic_search)
                OutlinedTextField(
                    value = "Search",
                    onValueChange = { },
                    modifier = Modifier
                        .padding(horizontal = 20.dp)
                        .fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            painter = searchIcon,
                            contentDescription = null,
                            tint = Color.Green,
                            modifier = Modifier.size(20.dp, 20.dp),
                        )
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth(),
                ) {

                    Text(
                        text = "Recommended",
                        modifier = Modifier.padding(20.dp, 0.dp, 0.dp, 0.dp),
                        color = MaterialTheme.colors.onSurface,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.h6
                    )
                    Text(
                        text = "See All",
                        modifier = Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp),
                        color = MaterialTheme.colors.onSurface,
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        item {
            LazyRow {
                items(recommendedCatsList) {
                    recommendedCatsList.forEach {
                        RecommendedCatItem(it)
                    }
                }
            }
        }
        items(recommendedCatsList) {
            catsList.forEach {
                RecommendedCatItem(it)
            }
        }
    }
}

@Composable
fun RecommendedCatItem(cat : Cat) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp,10.dp,20.dp,10.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = { }),
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.onSurface
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            val image: Painter = painterResource(id = cat.image)
            Image(
                modifier = Modifier
                    .size(80.dp, 80.dp)
                    .clip(RoundedCornerShape(16.dp)),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(
                    text = cat.name,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.Bold,
                    style = typography.subtitle1
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = buildString {
                        append(cat.age)
                        append("yrs | ")
                        append(cat.gender)
                    },
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                    color = MaterialTheme.colors.surface,
                    style = typography.caption
                )
            }
        }

    }
}
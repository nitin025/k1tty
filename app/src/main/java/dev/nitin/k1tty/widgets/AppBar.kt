package dev.nitin.k1tty.widgets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.nitin.k1tty.R
import dev.nitin.k1tty.ui.theme.typography

@Composable
fun AppBar(onToggle: () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        WigglesThemeSwitch(onToggle = { onToggle() })

        Card(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .clickable(onClick = {}),
            elevation = 4.dp,
            backgroundColor = MaterialTheme.colors.onSurface
        ) {
            Row()
            {
                Text(
                    text = "Nitin Sabale",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    color = MaterialTheme.colors.surface,
                    fontWeight = FontWeight.SemiBold,
                    style = typography.subtitle1
                )
                val image: Painter = painterResource(id = R.drawable.k1tty_owner)
                Image(
                    modifier = Modifier
                        .size(40.dp, 40.dp)
                        .clip(RoundedCornerShape(20.dp)),
                    painter = image,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

@Composable
fun WigglesThemeSwitch(onToggle: () -> Unit) {

    val icon = if (isSystemInDarkTheme())
        painterResource(id = R.drawable.ic_light_mode)
    else
        painterResource(id = R.drawable.ic_dark_mode)

    Icon(
        painter = icon,
        contentDescription = null,
        modifier = Modifier
            .size(30.dp, 30.dp)
            .clickable(onClick = onToggle),
//        tint = colorResource(id = R.color.text)
    )
}
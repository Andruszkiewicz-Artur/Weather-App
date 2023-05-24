package com.example.weatherapp.unit.compose.specifyWeatherInfo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun WeatherDataInfo(
    value: Int,
    unit: String,
    icon: ImageVector,
    iconDesc: String? = null,
    modifier: Modifier = Modifier,
    iconTint: Color = Color.White,
    title: String
) {
    Card(
        modifier = Modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = RoundedCornerShape(16.dp)
            )
            .shadow(
                elevation = 5.dp
            )
    ) {
        Column(
            modifier = modifier
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = iconDesc,
                tint = iconTint,
                modifier = Modifier.size(25.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "$value$unit",
                style = MaterialTheme.typography.subtitle1
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.subtitle2.copy(color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f)),
            )
        }
    }
}
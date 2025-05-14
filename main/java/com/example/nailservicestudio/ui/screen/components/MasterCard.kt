package com.example.nailservicestudio.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nailservicestudio.ui.theme.TextBlackColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@Composable
fun MasterCard(
    name: String,
    count: String,
    url: String,
    phoneNumber: String,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape),
            painter = rememberAsyncImagePainter(url),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            text = name,
            style = defaultTextStyle.bodyRegular16.copy(color = TextBlackColor)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            text = "Свободных мест: $count",
            style = defaultTextStyle.bodyRegular16.copy(color = TextBlackColor)
        )

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Preview
@Composable
private fun AppTextFieldPreview() {
    MasterCard(
        name = "Екатерина Мизулина",
        count = "31",
        url = "",
        phoneNumber = "234324234"
    )
}
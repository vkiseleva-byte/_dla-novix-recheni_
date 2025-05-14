package com.example.nailservicestudio.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.nailservicestudio.ui.theme.PinkColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.TextBlackColor
import com.example.nailservicestudio.ui.theme.White
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@Composable
fun ServiceCard(
    name: String,
    description: String,
    url: String,
    service: String,
    price: String,
    onClick: () -> Unit = {}
) {

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(White)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(PinkColor)
                    .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            ) {
                Text(
                    modifier = Modifier
                        .padding(12.dp)
                        .weight(5f),
                    text = service,
                    style = defaultTextStyle.bodyRegular16.copy(color = TextBlackColor)
                )

                Spacer(modifier = Modifier.width(10.dp))

                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .weight(5f)
                        .clip(RoundedCornerShape(30.dp)),
                    painter = rememberAsyncImagePainter(url),
                    contentDescription = null
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            text = name,
            style = defaultTextStyle.headingSemiBold20.copy(color = TextBlackColor)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 12.dp),
            text = description,
            style = defaultTextStyle.bodyRegular16.copy(color = TextBlackColor)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row {
            Text(
                modifier = Modifier
                    .padding(horizontal = 12.dp),
                text = "$price₽",
                style = defaultTextStyle.headingMedium20.copy(color = PrimaryColor)
            )

            Spacer(modifier = Modifier.weight(1f))

            AppButton(
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(10.dp)),
                text = "Выбрать",
                textStyle = defaultTextStyle.buttonText,
                onClick = {},
            )
        }

        Spacer(modifier = Modifier.height(12.dp))
    }
}


@Preview
@Composable
private fun AppTextFieldPreview() {
    ServiceCard(
        name = "Маникюр классический",
        description = "Маникюр классический Маникюр классический Маникюр классический",
        url = "",
        service = "Маникюр классическийМаникюр классическийМаникюр классическийМаникюр классическийМаникюр классическийМаникюр классический",
        price = "800"
    )
}
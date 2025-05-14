package com.example.nailservicestudio.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@Composable
fun MedicineDetail(
    name: String,
    count: String,
    url: String,
    phoneNumber: String,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        MedicineWithoutDivider(name = name, url = url)

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Услуги:",
            style = defaultTextStyle.headingSemiBold20.copy(color = PrimaryColor)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Маникюр + гель лак",
            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Маникюр гигиенический",
            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
        )

        Spacer(modifier = Modifier.height(2.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Пальчики + гель лак",
            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Номер телефона:",
            style = defaultTextStyle.headingSemiBold20.copy(color = PrimaryColor)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = phoneNumber,
            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = "Количество свободных мест:",
            style = defaultTextStyle.headingSemiBold20.copy(color = PrimaryColor)
        )

        Spacer(modifier = Modifier.height(6.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = count,
            style = defaultTextStyle.bodyMedium14.copy(color = TextGrayColor)
        )

    }
}

@Composable
fun MedicineWithoutDivider(
    name: String,
    url: String,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick()
            },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Image(
            modifier = Modifier
                .size(271.dp)
                .clip(CircleShape)
                .align(alignment = Alignment.CenterHorizontally),
            painter = rememberAsyncImagePainter(url),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .padding(horizontal = 24.dp),
            text = name,
            style = defaultTextStyle.headingMedium20.copy(color = TextGrayColor)
        )

        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Preview
@Composable
private fun AppTextFieldPreview() {
    MedicineDetail(
        name = "Сергеева Марина",
        url = "",
        phoneNumber = "+79999999999",
        count = "1"
    )
}
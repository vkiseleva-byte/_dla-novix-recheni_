package com.example.nailservicestudio.ui.screen.services

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nailservicestudio.R
import com.example.nailservicestudio.ui.screen.components.ServiceCard
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServicesScreen(
    navController: NavController
) {

    Scaffold(
        topBar = {
            Surface(color = SecondaryColor, shadowElevation = 8.dp) {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentSize(Alignment.Center),
                            text = "Выбрать услуги",
                            style = defaultTextStyle.subtitleMedium16.copy(color = DarkGrayColor)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.arrow_square_right),
                                contentDescription = null,
                                tint = PrimaryColor,
                            )
                        }
                    },
                    modifier = Modifier.clickable { navController.navigateUp() }
                )
            }
        }
    )
    { containerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(SecondaryColor)
                .padding(containerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                ServiceCard(
                    service = "Маникюр\nКлассический\nЕвропейский\nАппаратный\nКомбинированный",
                    name = "Маникюр классический/ европейский/аппаратный/ комбинированный",
                    description = "Придание формы ногтям; способ обработки кутикулы: классический (обрезной), европейский, комбинированный, аппаратный; мини-массаж с кремом; масло для кутикулы.",
                    price = "800",
                    url = "https://i3.wp.com/mia-bags.ru/wp-content/uploads/3/d/0/3d058f7c73f6b5682e20364b038ac7a0.jpeg?resize=768%2C768&ssl=1"
                )

                Spacer(modifier = Modifier.height(20.dp))

                ServiceCard(
                    service = "Бразильский маникюр",
                    name = "Бразильский маникюр",
                    description = "Придание формы ногтям; использование перчаток с эмульсией способ обработки кутикулы обрезной; мини- массаж с эмульсией; масло для кутикулы.",
                    price = "1200",
                    url = "https://glamours.name/uploads/posts/2023-03/thumbs/1678480997_glamours-name-p-pishain-yaponskii-manikyur-zhenskie-krasiv-79.jpg"
                )

                Spacer(modifier = Modifier.height(20.dp))

                ServiceCard(
                    service = "Мужской маникюр",
                    name = "Мужской маникюр",
                    description = "Придание формы ногтям; способ обработки кутикулы: классический (обрезной), европейский, комбинированный, аппаратный; мини-массаж с кремом; масло для кутикулы.",
                    price = "1000",
                    url = "https://avatars.mds.yandex.net/get-ydo/3904573/2a0000018a97b78c22d33e65f3134c63619e/diploma"
                )

                Spacer(modifier = Modifier.height(20.dp))

                ServiceCard(
                    service = "Детский маникюр",
                    name = "Детский маникюр",
                    description = "Придание формы ногтям; без обработки кутикулы; нанесение цветного лака для ногтей; мини- массаж с кремом; масло для кутикулы.",
                    price = "500",
                    url = "https://modnica.club/uploads/posts/2021-11/thumbs/1638229802_27-modnica-club-p-detskii-manikyur-tekhnologiya-vipolneniya-29.jpg"
                )

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Preview
@Composable
private fun HolderPreview() {
    ServicesScreen(
        navController = rememberNavController()
    )
}
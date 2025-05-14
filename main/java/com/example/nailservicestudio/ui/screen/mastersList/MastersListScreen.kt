package com.example.nailservicestudio.ui.screen.mastersList

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.example.nailservicestudio.ui.navigation.ScreensRouts
import com.example.nailservicestudio.ui.screen.components.MasterCard
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MastersList(
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
                            text = "Мастера",
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
                .padding(containerPadding)
        ) {
            Column(
                modifier = Modifier
                    .background(SecondaryColor)
                    .verticalScroll(rememberScrollState())
            ) {
                Text(
                    modifier = Modifier
                        .padding(vertical = 30.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "НАШИ МАСТЕРА",
                    style = defaultTextStyle.headingMedium20.copy(color = TextGrayColor)
                )

                Row {
                    MasterCard(
                        name = "Емельянова Светлана",
                        count = "12",
                        phoneNumber = "+7 923 433-34-34",
                        url = "https://avatars.mds.yandex.net/i?id=aea95cef95140a6e550d43a9e4c4c92d_l-12422034-images-thumbs&n=13", // Показываем оригинальную ссылку
                        onClick = {
                            navController.navigate(
                                "${ScreensRouts.MasterServicesScreen.route}/Емельянова Светлана/12/+7 923 433-34-34/${
                                    Uri.encode(
                                        "https://avatars.mds.yandex.net/i?id=aea95cef95140a6e550d43a9e4c4c92d_l-12422034-images-thumbs&n=13"
                                    )
                                }"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    MasterCard(
                        name = "Денисова Анна",
                        count = "3",
                        phoneNumber = "+7 923 122-34-34",
                        url = "https://p0.zoon.ru/preview/xB9ZYGCLWLaJjsJ2x10lmQ/800x800x85/1/c/a/original_592c09ad7ad2fe33a62450a9_5932e63725e0a.jpg", // Показываем оригинальную ссылку
                        onClick = {
                            navController.navigate(
                                "${ScreensRouts.MasterServicesScreen.route}/Денисова Анна/3/+7 923 122-34-34/${
                                    Uri.encode(
                                        "https://p0.zoon.ru/preview/xB9ZYGCLWLaJjsJ2x10lmQ/800x800x85/1/c/a/original_592c09ad7ad2fe33a62450a9_5932e63725e0a.jpg"
                                    )
                                }"
                            )
                        }
                    )
                }

                Row {
                    MasterCard(
                        name = "Белякова Анжелика",
                        count = "4",
                        phoneNumber = "+7 923 324-34-34",
                        url = "https://avatars.mds.yandex.net/i?id=97399b6a60d759efc8d90193ef6e7bd2_l-5284174-images-thumbs&n=13",
                        onClick = {
                            navController.navigate(
                                "${ScreensRouts.MasterServicesScreen.route}/Белякова Анжелика/4/+7 923 324-34-34/${
                                    Uri.encode(
                                        "https://avatars.mds.yandex.net/i?id=97399b6a60d759efc8d90193ef6e7bd2_l-5284174-images-thumbs&n=13"
                                    )
                                }"
                            )
                        }
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    MasterCard(
                        name = "Морозова Ева",
                        count = "1",
                        phoneNumber = "+7 923 978-34-34",
                        url = "https://sun1-98.userapi.com/s/v1/if1/TFyBOSdUvjwGncBwgqEjE-67FF61H1kgVWRyHs3T10nQXITMEpxyB6q5DYs2umgQE1YQXn7q.jpg?size=640x640&quality=96&crop=40,0,640,640&ava=1",
                        onClick = {
                            navController.navigate(
                                "${ScreensRouts.MasterServicesScreen.route}/Морозова Ева/1/+7 923 978-34-34/${
                                    Uri.encode(
                                        "https://sun1-98.userapi.com/s/v1/if1/TFyBOSdUvjwGncBwgqEjE-67FF61H1kgVWRyHs3T10nQXITMEpxyB6q5DYs2umgQE1YQXn7q.jpg?size=640x640&quality=96&crop=40,0,640,640&ava=1"
                                    )
                                }"
                            )
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun HolderPreview() {
    MastersList(
        navController = rememberNavController()
    )
}
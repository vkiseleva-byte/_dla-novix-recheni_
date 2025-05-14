package com.example.nailservicestudio.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nailservicestudio.R
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.TextBlackColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
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
                            text = "Мой профиль",
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
            ) {
                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    modifier = Modifier
                        .size(271.dp)
                        .clip(CircleShape)
                        .align(alignment = Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.photo_user),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp)
                        .align(alignment = Alignment.CenterHorizontally),
                    text = "Виктория Киселева",
                    style = defaultTextStyle.headingMedium20.copy(color = TextBlackColor)
                )

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    text = "Записи:",
                    style = defaultTextStyle.subtitleBold16.copy(color = TextBlackColor)
                )

                Spacer(modifier = Modifier.height(100.dp))

                Text(
                    modifier = Modifier
                        .padding(horizontal = 24.dp),
                    text = "У вас нет назначенных записей",
                    style = defaultTextStyle.bodySemiBold14.copy(color = TextGrayColor)
                )
            }
        }
    }
}

@Preview
@Composable
private fun HolderPreview() {
    ProfileScreen(
        navController = rememberNavController()
    )
}
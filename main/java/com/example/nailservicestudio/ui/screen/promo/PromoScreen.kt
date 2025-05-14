package com.example.nailservicestudio.ui.screen.promo

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
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nailservicestudio.R
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PromoScreen(
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
                            text = "Акции",
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
                .background(White)
                .padding(containerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = "Сегодня",
                    style = defaultTextStyle.subtitleMedium18.copy(color = DarkGrayColor)
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    modifier = Modifier.padding(top = 110.dp),
                    text = "Извините,\nна данный момент актуальных акций нет :(",
                    style = defaultTextStyle.headingBold24.copy(color = TextGrayColor),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun HolderPreview() {
    PromoScreen(
        navController = rememberNavController()
    )
}
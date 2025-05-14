package com.example.nailservicestudio.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.nailservicestudio.ui.navigation.ScreensRouts
import com.example.nailservicestudio.ui.screen.components.AppButton
import com.example.nailservicestudio.ui.screen.components.AppTextField
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LogInScreen(
    vm: LogInViewModel,
    navController: NavController
) {
    val state = vm.state

    LaunchedEffect(state.error) {
        if (state.error == "true") {
            navController.navigate(
                ScreensRouts.HomeScreen.route,
                builder = {
                    popUpTo(ScreensRouts.SignUpScreen.route) {
                        inclusive = true
                    }
                }
            )
        }
    }

    if (state.error != null && state.error != "true") {
        AlertDialog(
            onDismissRequest = { vm.dismissError() },
            title = { Text(text = "Что-то пошло не так") },
            text = { Text(text = state.error) },
            confirmButton = {
                Button(onClick = { vm.dismissError() }) {
                    Text(text = "Ok")
                }
            },
        )
    }

    Scaffold { containerPadding ->
        if (!state.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SecondaryColor)
                    .padding(containerPadding)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = DefaultTopPadding, end = 23.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        modifier = Modifier.padding(top = 110.dp),
                        text = "Здравствуйте!",
                        style = defaultTextStyle.headingBold24.copy(color = TextGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = DefaultTopTextPadding),
                        text = "Войдите, чтобы воспользоваться функционалом приложения",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = 20.dp),
                        text = "E-mal",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.email,
                        onValueChange = { newEmail ->
                            vm.updateEmail(newEmail)
                        },
                        hintText = "**********@mail.com"
                    )
                    Text(
                        modifier = Modifier.padding(top = 24.dp),
                        text = "Пароль",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.password,
                        onValueChange = { newPassword ->
                            vm.updatePassword(newPassword)
                        },
                        isPassword = true,
                        hintText = "********"
                    )
                    AppButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 187.dp),
                        text = "Войти",
                        textStyle = defaultTextStyle.buttonText,
                        buttonEnabled = state.buttonEnabled,
                        onClick = {
                            if (state.buttonEnabled) {
                                vm.logIn()
                            }
                        }
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 20.dp, bottom = 18.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            modifier = Modifier.padding(end = 3.dp),
                            text = "Нет аккаунта?",
                            style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                        )
                        Text(
                            modifier = Modifier.clickable { navController.navigate(ScreensRouts.SignUpScreen.route) },
                            text = "Зарегистрироваться",
                            style = defaultTextStyle.bodyMedium14.copy(color = PrimaryColor),
                        )
                    }
                }
            }
        } else {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
            ) {
                CircularProgressIndicator()
            }
        }
    }
}

@Preview
@Composable
private fun LogInScreenPreview() {
    LogInScreen(
        vm = LogInViewModel(),
        navController = rememberNavController()
    )
}
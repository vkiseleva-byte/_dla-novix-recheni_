package com.example.oech_app.ui.screen.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.nailservicestudio.ui.screen.signUp.SignUpViewModel
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.SecondaryColor
import com.example.nailservicestudio.ui.theme.TextGrayColor
import com.example.nailservicestudio.ui.theme.defaultTextStyle

private val DefaultTopPadding = 24.dp
private val DefaultTopTextPadding = 8.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    vm: SignUpViewModel,
    navController: NavController
) {
    val state = vm.state

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
                        modifier = Modifier.padding(top = 33.dp),
                        text = "Создание аккаунта",
                        style = defaultTextStyle.headingBold24.copy(color = TextGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = DefaultTopTextPadding),
                        text = "Закончите процесс регастрации чтобы продолжить",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = "Имя",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.fullName,
                        onValueChange = { newName ->
                            vm.updateName(newName)
                        },
                        hintText = "Иванов Иван"
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = "Номер телефона",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.phoneNumber,
                        onValueChange = { newPhone ->
                            vm.updatePhone(newPhone)
                        },
                        hintText = "+7 (999) 999-99-99"
                    )
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = "E-mail",
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
                        modifier = Modifier.padding(top = 33.dp),
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
                    Text(
                        modifier = Modifier.padding(top = 33.dp),
                        text = "Подтвердите пароль",
                        style = defaultTextStyle.bodyMedium14.copy(color = DarkGrayColor)
                    )
                    AppTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = DefaultTopTextPadding),
                        value = state.confirmPassword,
                        onValueChange = { newConfirmPassword ->
                            vm.updateConfirmPassword(newConfirmPassword)
                        },
                        isPassword = true,
                        hintText = "********"
                    )
                    AppButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 64.dp),
                        text = "Зарегистрироваться",
                        textStyle = defaultTextStyle.buttonText,
                        buttonEnabled = state.buttonEnabled,
                        onClick = {
                            if (state.buttonEnabled) {
                                vm.signUp()
                                navController.navigate(ScreensRouts.LogInScreen.route)
                            }
                        }
                    )
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
private fun SignUpScreenPreview() {
    SignUpScreen(
        vm = SignUpViewModel(),
        navController = rememberNavController()
    )
}
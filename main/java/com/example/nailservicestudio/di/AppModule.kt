package com.example.nailservicestudio.di

import org.koin.dsl.module
import com.example.nailservicestudio.ui.screen.login.LogInViewModel
import com.example.nailservicestudio.ui.screen.signUp.SignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {
    viewModel {
        LogInViewModel()
    }
    viewModel {
        SignUpViewModel()
    }
}
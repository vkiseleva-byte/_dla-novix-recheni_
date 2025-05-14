package com.example.nailservicestudio.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.nailservicestudio.R

data class AppTextStyle(
    val headingBlack128: TextStyle,
    val headingBlack96: TextStyle,
    val headingExtraBold64: TextStyle,
    val headingExtraBold36: TextStyle,
    val headingBold36: TextStyle,
    val headingBold24: TextStyle,
    val headingMedium24: TextStyle,
    val headingSemiBold20: TextStyle,
    val headingMedium20: TextStyle,
    val subtitleMedium18: TextStyle,
    val subtitleBold16: TextStyle,
    val subtitleMedium16: TextStyle,
    val subtitleRegular16: TextStyle,
    val bodyRegular16: TextStyle,
    val bodySemiBold14: TextStyle,
    val bodyMedium14: TextStyle,
    val bodyRegular14: TextStyle,
    val bodyMedium12: TextStyle,
    val bodyRegular12: TextStyle,
    val buttonText: TextStyle
)

val defaultTextStyle = AppTextStyle(
    headingBlack128 = TextStyle(
        fontSize = 128.sp,
        lineHeight = 128.sp,
        fontFamily = FontFamily(Font(R.font.roboto_900))
    ),
    headingBlack96 = TextStyle(
        fontSize = 96.sp,
        lineHeight = 120.sp,
        fontFamily = FontFamily(Font(R.font.roboto_900))
    ),
    headingExtraBold64 = TextStyle(
        fontSize = 64.sp,
        lineHeight = 64.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    headingExtraBold36 = TextStyle(
        fontSize = 36.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.ExtraBold
    ),
    headingBold36 = TextStyle(
        fontSize = 36.sp,
        lineHeight = 36.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    headingBold24 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    headingMedium24 = TextStyle(
        fontSize = 24.sp,
        lineHeight = 30.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    headingSemiBold20 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    headingMedium20 = TextStyle(
        fontSize = 20.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    subtitleMedium18 = TextStyle(
        fontSize = 18.sp,
        lineHeight = 18.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    subtitleBold16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    subtitleMedium16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    subtitleRegular16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodyRegular16 = TextStyle(
        fontSize = 16.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodySemiBold14 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 14.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
    bodyMedium14 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    bodyRegular14 = TextStyle(
        fontSize = 14.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    bodyMedium12 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_500))
    ),
    bodyRegular12 = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily(Font(R.font.roboto_400))
    ),
    buttonText = TextStyle(
        fontSize = 14.sp,
        lineHeight = 9.38.sp,
        fontFamily = FontFamily(Font(R.font.roboto_700))
    ),
)
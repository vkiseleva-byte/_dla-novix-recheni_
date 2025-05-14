package com.example.nailservicestudio.ui.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.nailservicestudio.ui.theme.DarkGrayColor
import com.example.nailservicestudio.ui.theme.PrimaryColor
import com.example.nailservicestudio.ui.theme.TextBlackColor
import com.example.nailservicestudio.ui.theme.White
import com.example.nailservicestudio.ui.theme.defaultTextStyle

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    modifierText: Modifier = Modifier,
    backgroundColor: Color = PrimaryColor,
    contentColor: Color = White,
    text: String,
    textStyle: TextStyle,
    buttonEnabled: Boolean = true,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        colors = if (buttonEnabled) {
            ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = contentColor
            )
        } else ButtonDefaults.buttonColors(
            containerColor = DarkGrayColor,
            contentColor = contentColor
        ),
        onClick = onClick,
        shape = RoundedCornerShape(CornerSize(4.69.dp)),
        border = BorderStroke(1.dp, if (buttonEnabled) PrimaryColor else DarkGrayColor)
    ) {
        BasicText(
            modifier = modifierText.padding(horizontal = 8.dp, vertical = 4.dp),
            text = text,
            style = if (backgroundColor == PrimaryColor) {
                textStyle.copy(color = White)
            } else {
                textStyle.copy(color = TextBlackColor)
            }
        )
    }
}

@Preview
@Composable
private fun AppTextFieldPreview() {
    AppButton(
        modifier = Modifier.fillMaxWidth(),
        text = "asdadasd",
        textStyle = defaultTextStyle.buttonText
    )
}

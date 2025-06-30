package com.mlg.navigation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mlg.navigation.R

@Preview
@Composable
fun CartScreen() {
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.green))
    ) {
        Text(
            textAlign = TextAlign.Center,
            text = "Cart Screen",
            color = colorResource(R.color.white),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold)
        )
    }
}
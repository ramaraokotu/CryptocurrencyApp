package com.mobile.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mobile.cryptocurrencyapp.R
import com.mobile.cryptocurrencyapp.data.remote.dto.TeamMember

@Composable
fun TeamListItem(
    teamMember: TeamMember,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = teamMember.name,
            style = MaterialTheme.typography.titleMedium,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            color = colorResource(id = R.color.colorText)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = teamMember.position,
            style = MaterialTheme.typography.titleSmall,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif,
            color = colorResource(id = R.color.colorGray)
        )
    }
}
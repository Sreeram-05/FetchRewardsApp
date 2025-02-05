package com.sreeram.fetchrewardsapp.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sreeram.fetchrewardsapp.presentation.composables.ListDetailScreen
import com.sreeram.fetchrewardsapp.presentation.theme.FetchRewardsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FetchRewardsAppTheme {
                ListDetailScreen()
            }
        }
    }
}
package com.example.openspotify

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.openspotify.ui.theme.OpenSpotifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch Spotify
        val spotifyIntent = packageManager.getLaunchIntentForPackage("com.spotify.music")
        if (spotifyIntent != null) {
            startActivity(spotifyIntent)
        } else {
            // If Spotify is not installed, open Play Store
            val playStoreIntent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("market://details?id=com.spotify.music")
            }
            startActivity(playStoreIntent)
        }

        // Finish the activity to prevent staying in the task stack
        finish()
    }
}

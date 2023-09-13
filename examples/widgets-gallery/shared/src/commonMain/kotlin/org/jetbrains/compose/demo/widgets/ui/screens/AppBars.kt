package org.jetbrains.compose.demo.widgets.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Search

import androidx.compose.material3.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.demo.widgets.theme.twitterColor
import org.jetbrains.compose.demo.widgets.ui.WidgetsType
import org.jetbrains.compose.demo.widgets.ui.utils.SubtitleText
import org.jetbrains.compose.demo.widgets.ui.utils.TitleText
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import widgets_gallery.shared.generated.resources.Res
import widgets_gallery.shared.generated.resources.ic_instagram
import widgets_gallery.shared.generated.resources.ic_send
import widgets_gallery.shared.generated.resources.ic_twitter
import widgets_gallery.shared.generated.resources.p6
import widgets_gallery.shared.generated.resources.spotify_nav_home
import widgets_gallery.shared.generated.resources.spotify_nav_library
import widgets_gallery.shared.generated.resources.spotify_nav_search

@Composable
fun AppBars() {
    Column(Modifier.testTag(WidgetsType.APP_BARS.testTag)) {
        TopAppBarsDemo()
        BottomAppBarDemo()
        NavigationBarDemo()
    }
}

@Composable
private fun TopAppBarsDemo() {
    SubtitleText(subtitle = "Top App bar")

    TopAppBar(
        title = { Text(text = "Home") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.AutoMirrored.Default.ArrowBack, contentDescription = "ArrowBack")
            }
        },
    )

    Spacer(modifier = Modifier.height(8.dp))

    TopAppBar(
        title = { Text(text = "Instagram") },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors( // Set colors for M3
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.ic_instagram), contentDescription = "Instagram")
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(painterResource(Res.drawable.ic_send), contentDescription = "Send")
            }
        }
    )

    Spacer(modifier = Modifier.height(8.dp))

    TopAppBar(
        title = {
            Icon(
                painterResource(Res.drawable.ic_twitter),
                contentDescription = "Twitter",
                tint = twitterColor,
                modifier = Modifier.fillMaxWidth()
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors( // Set colors for M3
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        navigationIcon = {
            Image(
                painterResource(Res.drawable.p6),
                contentDescription = "",
                modifier =
                    Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                        .requiredSize(32.dp)
                        .clip(CircleShape),
            )
        },
        actions = {
            Icon(
                Icons.Default.Star,
                contentDescription = "",
                modifier = Modifier.padding(horizontal = 8.dp),
            )
        }
    )
    Spacer(modifier = Modifier.height(8.dp))
}

@Composable
private fun BottomAppBarDemo() {
    Spacer(modifier = Modifier.height(16.dp))
    SubtitleText("Bottom app bars: Note bottom app bar support FAB cutouts when used with scaffolds see demoUI crypto app")

    BottomAppBar(
        // no cutouts in M3
//        cutoutShape = CircleShape
    ) {
        IconButton(onClick = {}) {
            Icon(Icons.Default.MoreVert, contentDescription = "")
        }
        TitleText(title = "Bottom App Bar")
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun NavigationBarDemo() {
    Spacer(modifier = Modifier.height(16.dp))
    SubtitleText(subtitle = "Bottom Navigation Bars")
    val navItemState = remember { mutableStateOf(NavType.HOME) }
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Home, contentDescription = "Home") },
            selected = navItemState.value == NavType.HOME,
            onClick = { navItemState.value = NavType.HOME },
            label = { Text(text = stringResource(Res.string.spotify_nav_home)) },
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
            selected = navItemState.value == NavType.SEARCH,
            onClick = { navItemState.value = NavType.SEARCH },
            label = { Text(text = stringResource(Res.string.spotify_nav_search)) },
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.MailOutline, contentDescription = "LibraryMusic") },
            selected = navItemState.value == NavType.LIBRARY,
            onClick = { navItemState.value = NavType.LIBRARY },
            label = { Text(text = stringResource(Res.string.spotify_nav_library)) },
        )
    }

    Spacer(modifier = Modifier.height(16.dp))

    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Outlined.List, contentDescription = "ReadMore") },
            selected = navItemState.value == NavType.HOME,
            onClick = { navItemState.value = NavType.HOME },
        )
        NavigationBarItem(
            icon = { Icon(Icons.Outlined.Search, contentDescription = "Search") },
            selected = navItemState.value == NavType.SEARCH,
            onClick = { navItemState.value = NavType.SEARCH },
        )
        NavigationBarItem(
            icon = { Icon(Icons.AutoMirrored.Outlined.Send, contentDescription = "CleanHands") },
            selected = navItemState.value == NavType.LIBRARY,
            onClick = { navItemState.value = NavType.LIBRARY },
        )
    }
}

private enum class NavType {
    HOME,
    SEARCH,
    LIBRARY
}
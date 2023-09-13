package org.jetbrains.compose.demo.widgets.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.demo.widgets.data.DemoDataProvider
import org.jetbrains.compose.demo.widgets.theme.typography
import org.jetbrains.compose.demo.widgets.ui.WidgetsType
import org.jetbrains.compose.resources.painterResource
import widgets_gallery.shared.generated.resources.Res
import widgets_gallery.shared.generated.resources.p1
import widgets_gallery.shared.generated.resources.p2
import widgets_gallery.shared.generated.resources.p3

@Composable
fun UICards() {
    Column(Modifier.testTag(WidgetsType.UI_CARDS.testTag)) {
        val item = remember { DemoDataProvider.item }

        Text(
            text = "Inbuilt box as container for any Clipping/Alignment controls",
            style = typography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )
        Card(
            modifier = Modifier.padding(8.dp).fillMaxWidth(),
//            backgroundColor = MaterialTheme.colors.primary,
            shape = RoundedCornerShape(topStart = 16.dp, bottomEnd = 16.dp)
        ) {
            Column {
                Text(
                    text = item.title,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
                Text(
                    text = item.subtitle,
                    modifier = Modifier.padding(8.dp),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
        Divider()

        Text(text = "Inbuilt Card", style = typography.titleMedium, modifier = Modifier.padding(8.dp))
        Card(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            shape = RoundedCornerShape(4.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row {
                Image(
                    painterResource(Res.drawable.p3),
                    contentDescription = null,
                    modifier = Modifier.requiredSize(60.dp)
                )
                Text(text = item.title, modifier = Modifier.padding(16.dp))
            }
        }
        Divider()

        Text(
            text = "In-built ListItems",
            style = typography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )
        ListItem(headlineContent = { Text(item.title) }, supportingContent = { Text(item.subtitle) })
        Divider(modifier = Modifier.padding(4.dp))
        ListItem(
            headlineContent = { Text(item.title) },
            supportingContent = { Text(item.subtitle) },
        )
        Divider(modifier = Modifier.padding(4.dp))
        ListItem(headlineContent = { Text(item.title) }, supportingContent = { Text(item.subtitle) }, leadingContent = {
            Image(
                painterResource(Res.drawable.p3),
                contentDescription = null
            )
        })
        Divider(modifier = Modifier.padding(4.dp))
        //I am not sure why this is not going multiline for secondaryText...
        ListItem(
            headlineContent = { Text(item.title) },
            supportingContent = { Text(item.subtitle) },
            leadingContent = {
                Image(
                    painterResource(Res.drawable.p1),
                    contentDescription = null
                )
            },
            overlineContent = { Text("Overline text") },
        )
        Divider()
        ListItem(
            headlineContent = { Text(item.title) },
            supportingContent = { Text(item.subtitle) },
            leadingContent = {
                Image(
                    painterResource(Res.drawable.p2),
                    contentDescription = null
                )
            },
            trailingContent = { Icon(Icons.Default.ShoppingCart, contentDescription = null) },
        )
        Divider()
    }
}
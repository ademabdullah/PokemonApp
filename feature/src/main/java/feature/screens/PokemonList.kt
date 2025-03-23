package feature.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import feature.ui.theme.PokemonAppTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier


@Composable
fun PokemonList() {
    val itemList = listOf("a", "b", "c")

    Scaffold( ) {innerPadding ->
        LazyColumn(modifier = Modifier.fillMaxSize()
            .padding(innerPadding)) {
            items(itemList.size) {
                Card(modifier = Modifier.fillMaxWidth().padding(16.dp)) {
                    Text(text = itemList[it])
                }
            }
        }
    }
}




@Preview
@Composable
fun PokemonListPreview() {
    //TODO: Implement preview
    PokemonAppTheme {
        PokemonList()
    }
}

package com.example.applibrary.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.applibrary.books
import com.example.applibrary.components.Header
import com.example.applibrary.components.PopularBooks
import com.example.applibrary.ui.theme.AppLibraryTheme

@Composable
fun BooksScreen(
    innerPadding : PaddingValues,
    navController: NavController
){
    val colors = MaterialTheme.colorScheme
    val typography = MaterialTheme.typography

    //LazyColumn para poder hacer scroll a toda la pantalla
    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
            .background(colors.background)
    )
    {
        //Usar componentes dentro de un LazyColumn
        item {
            Header(
                innerPadding
            )
        }

        item {
            Text(
                text = "Libros Populares"
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                items(books){
                    PopularBooks(
                        book = it,
                        navController = navController

                    )
                }

            }
        }


    }//Column papá

}


@Preview(
    showBackground = true,
    showSystemUi = true,
)
@Composable
fun BooksScreenPreview(){
    AppLibraryTheme(){
        BooksScreen(
            innerPadding = PaddingValues(15.dp),
            navController = rememberNavController() //NAVEGACIÓN
        )
    }
}

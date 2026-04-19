package com.example.applibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.applibrary.screens.BookDetailScreen
import com.example.applibrary.screens.BooksScreen
import com.example.applibrary.screens.CounterScreen
import com.example.applibrary.ui.theme.AppLibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppLibraryTheme {

                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //NAGEGACIÓN
                    NavHost(
                        //Ruta para iniciar ( cualquier nombre )
                        startDestination = "books",

                        //
                        navController = navController,
                    ) {
                        composable(route = "books") {
                            BooksScreen(innerPadding, navController)
                        }

                        composable(
                            route = "books/{id}",
                            arguments = listOf(
                                //Busca en la ruta numero entero y lo convierte a int.
                                navArgument(
                                    name = "id"
                                ) {
                                    type = NavType.IntType
                                    nullable = false
                                }
                            )
                        ) { backStack ->
                            val id = backStack.arguments?.getInt("id") ?: 0  // ?: trata nulos
                            BookDetailScreen(id)
                        }

                        composable(route = "counter") {
                            CounterScreen()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        AppLibraryTheme {
            Greeting("Android")
        }
    }
}

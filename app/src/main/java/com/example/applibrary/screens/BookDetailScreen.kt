package com.example.applibrary.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Headset
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.applibrary.books
import com.example.applibrary.ui.theme.AccentYellow
import com.example.applibrary.ui.theme.BackgroundLight
import com.example.applibrary.ui.theme.HeaderGreen

@Composable
fun BookDetailScreen(
    id: Int
) {
    val book = books.firstOrNull { b -> b.id == id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundLight)
    ) {
        // Cabecera Verde con curva (idéntica a la imagen)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(380.dp)
                .clip(RoundedCornerShape(bottomEnd = 80.dp))
                .background(HeaderGreen)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Portada del libro con sombra
                AsyncImage(
                    model = book?.imageUrl ?: "",
                    contentDescription = book?.title ?: "",
                    modifier = Modifier
                        .height(240.dp)
                        .width(160.dp)
                        .shadow(12.dp, RoundedCornerShape(12.dp))
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Título y Autor
                Text(
                    text = book?.title ?: "",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = book?.author ?: "",
                    fontSize = 16.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }

        // Fila de Estadísticas (Chips blancos con sombra)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StatItem(label = "RATING", value = book?.rating.toString())
            StatItem(label = "PAG", value = book?.pages ?: "")
            StatItem(label = "AUDIO", value = book?.audio ?: "")
            StatItem(label = "LENG", value = book?.language?.take(3)?.uppercase() ?: "INC")
        }

        // Botones de Acción (Amarillo Accent)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AccentYellow),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = "Leer ahora",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(50.dp)
                    .background(AccentYellow, CircleShape)
            ) {
                Icon(
                    imageVector = Icons.Default.Headset,
                    contentDescription = "Audio",
                    tint = Color.White
                )
            }
        }

        // Descripción
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Descripción",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = book?.description ?: "",
                fontSize = 15.sp,
                color = Color.Black.copy(alpha = 0.8f),
                lineHeight = 22.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Barra de navegación inferior
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
            color = Color.White,
            shadowElevation = 15.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Menu, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(28.dp))
                Icon(Icons.Default.Favorite, contentDescription = null, tint = AccentYellow, modifier = Modifier.size(28.dp))
            }
        }
    }
}

@Composable
fun RowScope.StatItem(label: String, value: String) {
    Column(
        modifier = Modifier
            .weight(1f)
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .padding(vertical = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            fontSize = 10.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.DarkGray
        )
        Text(
            text = value,
            fontSize = 13.sp,
            fontWeight = FontWeight.Medium,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookDetailScreenPreview() {
    BookDetailScreen(1)
}

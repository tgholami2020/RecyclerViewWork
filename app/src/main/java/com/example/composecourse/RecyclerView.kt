package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            UserList()
        }
        }
    }
data class User(
    val id: Int
)
val users= listOf(
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1),
    User(1)
)
@Composable
fun UserList(){
//    Column (modifier = Modifier.verticalScroll(rememberScrollState())){
//        for (i in 0..10){
//            UserCard()
//        }
//    }
    LazyColumn{
        items(users){ user->
            UserCard()
        }
    }
}
@Composable
fun UserCard(){
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(12.dp)
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.amirtaha),
                contentDescription = " ",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val context = LocalContext.current
                Text(
                    text = " hi there ...this is my son,my lovely son is named Amir Taha," +
                            "he is six months only in this picture.",
                    modifier = Modifier
                        .padding(12.dp),
                    color = Color.Blue,
                )
                Button(onClick = {
                }) {
                    Text(text = "View Profile")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun defaultPreview(){
    Surface(Modifier.fillMaxSize()) {
        UserList()
    }
}

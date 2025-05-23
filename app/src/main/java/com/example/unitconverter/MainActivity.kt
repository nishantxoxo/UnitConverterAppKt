package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.White


                )  {
                    UnitConverter()


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
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    UnitConverterTheme {
//        Greeting("Android")
//    }
//}


@Composable
fun UnitConverter (){
    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
        Text("unit converter")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "meow", onValueChange = {})
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "drop down button")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(onClick = {

                    }, text = { Text("Centimeters") })
                    DropdownMenuItem(text = { Text("Meters")}, onClick = {})

                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = {}) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "drop down button")
                }
                DropdownMenu(expanded = false, onDismissRequest = {}) {
                    DropdownMenuItem(onClick = {

                    }, text = { Text("Centimeters") })

                    DropdownMenuItem(text = { Text("Meters")}, onClick = {

                    })

                }
            }
//            val context = LocalContext.current
//            Button(onClick = {
//                Toast.makeText(
//                    context, " text  ", Toast.LENGTH_LONG
//                ).show()
//            }) {
//                Text("my button")
//            }
        }
        Spacer(modifier = Modifier.height(16.dp))

        Text("Result: ")
    }
}


@Preview
@Composable
fun UnitConverterPreview(){
    UnitConverter();
}
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = Color.DarkGray


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
    //these are two ways of creating state variables
//    val statething = remember { mutableStateOf("meow") }
//    // to access statehing.value
//    val secStateThing by remember { mutableStateOf("also meow") }
    // to access... simply secStateTHing



    //these are my state variables
    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters")}
    var outputUnit by remember { mutableStateOf("Meters") }


    var isExpanded by remember { mutableStateOf(false) }

    var isExpanded2 by remember { mutableStateOf(false) }

    var conversionFac = remember { mutableStateOf(0.01) }



    fun convertUnit(){
        val inputvaldouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputvaldouble * conversionFac.value * 100).roundToInt() / 100
        outputValue = result.toString()
    }


    Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally) {
        Text("unit converter", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = inputValue, onValueChange = {
            inputValue = it
        }, label = { Text("mylabel") })
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Box {
                Button(onClick = {
                    isExpanded = !isExpanded
                }) {
                    Text( if(inputUnit == "") "Select" else inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "drop down button")
                }
                DropdownMenu(expanded = isExpanded, onDismissRequest = {
                    isExpanded = !isExpanded
                }) {
                    DropdownMenuItem(onClick = {
                        inputUnit =  "Centimeters"
                        isExpanded = !isExpanded
                    }, text = { Text("Centimeters") })
                    DropdownMenuItem(text = { Text("Meters")}, onClick = {
                        inputUnit =  "Meters"
                        isExpanded = !isExpanded
                    })

                }

            }
            Spacer(modifier = Modifier.width(16.dp))
            Box{
                Button(onClick = {
                    isExpanded2 = !isExpanded2
                }) {
                    Text(if(outputUnit == "") "Select" else outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "drop down button")
                }
                DropdownMenu(expanded = isExpanded2, onDismissRequest = {
                    isExpanded2 = !isExpanded2
                }) {

                    DropdownMenuItem(onClick = {
                        outputUnit =  "Centimeters"
                        isExpanded2 = !isExpanded2
                    }, text = { Text("Centimeters") })

                    DropdownMenuItem(text = { Text("Meters")}, onClick = {
                        outputUnit =  "Meters"
                        isExpanded2 = !isExpanded2
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
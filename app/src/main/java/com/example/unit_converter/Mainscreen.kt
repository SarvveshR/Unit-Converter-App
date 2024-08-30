package com.example.unit_converter

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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Unitconverter(){
    var inputValue by remember{ mutableStateOf("") }//outline textfield
    var outputValue by remember{ mutableStateOf("") }//Result
    var inputUnit by remember{ mutableStateOf("Meters") }//Button 1
    var outputUnit by remember { mutableStateOf("Meters") }//Button 2
    var iExpanded by remember{ mutableStateOf(false) }//Dropdown menu 1
    var oExpanded by remember{ mutableStateOf(false) }//Dropdownmenu 2
    var conversionFactor = remember{ mutableStateOf(1.0) }
    var oconversionFactor = remember{ mutableStateOf(1.0) }
    fun ConvertUnit(){//State changes result changes
        var inputDoublevalue=inputValue.toDoubleOrNull()?:0.0
        var result=(inputDoublevalue *conversionFactor.value *100/oconversionFactor.value)/100
        outputValue=result.toString()
    }


    Column(modifier= Modifier.fillMaxSize(),verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text("Unitconverter ",modifier= Modifier.padding(20.dp))
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(value =inputValue , onValueChange ={
            inputValue=it
            ConvertUnit()


        }
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text("Result:${outputValue+" "+outputUnit}")
        Row(){
            // input box
            Box {

                Button(onClick = {iExpanded=true}) {

                    Text(inputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )

                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded=false }) {
                    DropdownMenuItem(text = { Text("Centimeter") }
                        , onClick = { inputUnit="Centimeter"
                            conversionFactor.value=0.01
                            iExpanded=false
                            ConvertUnit()
                        })
                    DropdownMenuItem(text = { Text("meters") }
                        , onClick = { inputUnit="Meters"
                            iExpanded=false
                            conversionFactor.value=1.00
                            ConvertUnit()})

                    DropdownMenuItem(text = { Text("feet") }
                        , onClick = { iExpanded=false
                            inputUnit="Feet"
                            conversionFactor.value=0.03
                            ConvertUnit()
                        })

                    DropdownMenuItem(text = { Text("Millimeters") }
                        , onClick = { iExpanded=false
                            inputUnit="Millimeters"
                            conversionFactor.value=0.001
                            ConvertUnit()
                        })


                }
            }
            Spacer(modifier= Modifier.width(20.dp))
            Box {

                Button(onClick = {oExpanded=true}) {

                    Text(outputUnit)
                    Icon(
                        Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down"
                    )

                }
                DropdownMenu(expanded=oExpanded, onDismissRequest = {oExpanded=false}){
                    DropdownMenuItem(text = { Text("Centimeter") }
                        , onClick = { oExpanded=false
                            outputUnit="Centimeter"
                            oconversionFactor.value=0.01
                            ConvertUnit()
                        })
                    DropdownMenuItem(text = { Text("Meters") }
                        , onClick = { oExpanded=false
                            outputUnit="Meter"
                            oconversionFactor.value=1.0
                            ConvertUnit()
                        })
                    DropdownMenuItem(text={ Text("Feet") },
                        onClick={oExpanded=false
                            outputUnit="Feet"
                            oconversionFactor.value=0.3
                            ConvertUnit()
                        })
                    DropdownMenuItem(text={ Text("Millimeters") },onClick={
                        oExpanded=false
                        outputUnit="Millimeter"
                        oconversionFactor.value=0.001
                        ConvertUnit()
                    })
                }
            }







        }
    }



}


/*



*/
@Preview(showBackground = true)
@Composable
fun ConPreview(){
    Unitconverter()
}

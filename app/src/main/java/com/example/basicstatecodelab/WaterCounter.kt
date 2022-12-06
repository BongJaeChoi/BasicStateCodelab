package com.example.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text(text = "내가 가진 안경 개수 :$count")
        }
        Row(Modifier.padding(8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10,
                modifier = Modifier.padding(8.dp),
            ) {
                Text("Add One")
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(8.dp),
            ) {
                Text("Clear water count")
            }
        }
    }
}


//상태를 소유하지 않으므로 Stateless
@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "내가 가진 안경 개수 :$count")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(8.dp),
        ) {
            Text("Add One")
        }
    }
}

//컴포저블이 가능한 상태를 적게 소유해야함
//상태를 끌어 올리는 것이 중요
//컴보저블에 필요한 상태만 전달!!
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0) }
    StatelessCounter(count = count, onIncrement = { count++ }, modifier = modifier)
}

@Composable
@Preview
fun WaterCounterPreview() {
    WaterCounter(modifier = Modifier)
}

package com.example.basicstatecodelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview(showBackground = true)
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    WellnessTaskList(
        list = wellnessViewModel.task,
        onCloseTask = { wellnessViewModel.remove(it) }
    ) { task: WellnessTask, checked: Boolean ->
        wellnessViewModel.changeTaskChecked(task, checked)
    }
}

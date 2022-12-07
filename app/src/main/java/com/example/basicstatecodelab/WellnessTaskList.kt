package com.example.basicstatecodelab

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(modifier = modifier, state = listState) {
        items(list, key = { task -> task.id }) { task ->
            WellnessTaskItem(taskItem = task.label, onCloseTask = { onCloseTask(task) })
        }
    }
}

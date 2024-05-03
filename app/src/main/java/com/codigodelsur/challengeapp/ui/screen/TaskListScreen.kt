package com.codigodelsur.challengeapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codigodelsur.challengeapp.data.AppDatabase
import com.codigodelsur.challengeapp.data.Task

@Composable
fun TaskListScreen() {
    val context = LocalContext.current
    val tasks = AppDatabase.getInstance(context = context).taskDao().getAll()

    Column(modifier = Modifier
            .fillMaxSize().verticalScroll(state = rememberScrollState())
            .background(color = Color.Black).padding(all = 16.dp)
    ) {
        for (task in tasks) TaskItem(task = task)
    }
}

@Composable
fun TaskItem(task: Task) {
    Column(modifier = Modifier.fillMaxWidth().padding(all = 8.dp)
            .background(color = Color.White,
                shape = RoundedCornerShape(size = 8.dp))
    ) {
        Text(text = task.title, color = Color.Black)
        Text(text = task.description, color = Color.DarkGray, fontSize = 10.sp)
    }
}

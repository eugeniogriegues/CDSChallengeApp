
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
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codigodelsur.challengeapp.data.AppDatabase
import com.codigodelsur.challengeapp.data.Task


// ******* AQUÍ INSERTÉ UNA BARRA DE BÚQUEDA CON EL FILTRO QUE ME HABÍAS COMENTADO (TANTO POR TITULO COMO POR DESCRIPCIÓN) *****
// LO PROBÉ MUCHAS VECES Y FUNCIONA BIEN, ES INCREÍBLE LA FACILIDAD CON LA QUE SE CREAN ESTOS COMPONENTES, TE AGRADEZCO POR ESTA OPORTUNIDAD DE SEGUIR APRENDIENDO!

@Composable
fun SearchScreen(items: List<Task>) {
    var searchText by remember { mutableStateOf("") }

    var filteredItems = items.filter { it.description.contains(searchText, ignoreCase = true) or  it.title.contains(searchText, ignoreCase = true) }


    Column(modifier = Modifier.fillMaxSize()) {
        TextField(
            value = searchText,

            onValueChange = {
                searchText = it

                filteredItems = items.filter { it.description.contains(searchText, ignoreCase = true) }



            },
            label = { Text("Buscar") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        for (task in filteredItems) TaskItem(task = task)

    }
}

@Composable
fun TaskListScreen() {
    val context = LocalContext.current

    //AppDatabase.getInstance(context = context).taskDao().insertAll(Task(29,"TEST","PRUEBA"))

    //AppDatabase.getInstance(context = context).taskDao().deleteTask(Task(29,"TEST","PRUEBA"))


    val tasks = AppDatabase.getInstance(context = context).taskDao().getAll()



    Column(modifier = Modifier
        .fillMaxSize().verticalScroll(state = rememberScrollState())
        .background(color = Color.Black).padding(all = 16.dp)
    )
    {
        SearchScreen(tasks)
        //for (task in tasks) TaskItem(task = task)

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
        //Text(text = task.id.toString(), color = Color.Blue)
    }
}

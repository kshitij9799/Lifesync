package com.example.lifesync.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.lifesync.R
import com.example.lifesync.db.Task
import com.example.lifesync.viewmodel.CompletedTaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CompletedTaskFragment : Fragment() {
    val completedTaskViewModel: CompletedTaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            completedTaskViewModel.allCompletedTask.observe(viewLifecycleOwner) {
                setContent {
                    completedTaskScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun completedTaskScreen(/*taskList: List<Task>*/) {

    Box(
        contentAlignment = Alignment.TopCenter
    ) {
        Column {
            Text(
                text = "Completed Task",
                modifier = Modifier.padding(0.dp, 12.dp).align(CenterHorizontally),
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white),
                fontSize = 20.sp
            )
            taskCards(
//                taskList
                listOf(
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending"),
                    Task(0, "task1", "desc1", "pending")
                )
            )
        }
    }
}


@Composable
fun taskCards(list: List<Task>?) {
    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {
        for (item in list ?: emptyList()) {
            Card(
                modifier = Modifier.fillMaxSize().padding(12.dp, 10.dp),
                shape = RoundedCornerShape(10),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.lightGrey)
                )
            ) {
                Column {
                    Text(
                        text = item.task,
                        modifier = Modifier.padding(12.dp, 20.dp, 12.dp, 2.dp),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        color = colorResource(id = R.color.white)
                    )
                    Text(
                        text = item.desc,
                        modifier = Modifier.padding(20.dp, 4.dp, 12.dp, 20.dp),
                        color = colorResource(id = R.color.white)
                    )
                }
            }
        }
    }
}
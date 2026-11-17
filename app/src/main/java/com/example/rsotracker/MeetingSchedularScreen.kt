package com.example.rsotracker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun MeetingSchedulerScreen(
    onBack: () -> Unit
) {
    val context = LocalContext.current

    val preferences = remember(context) {
        context.getSharedPreferences(
            "meeting_availability",
            android.content.Context.MODE_PRIVATE
        )
    }

    val days = listOf(
        "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday"
    )

    val times = listOf(
        "4:00 PM", "5:00 PM", "6:00 PM",
        "7:00 PM", "8:00 PM"
    )

    val selectedSlots = remember {
        mutableStateListOf<String>().apply {
            addAll(
                preferences.getStringSet(
                    "sia_meeting_slots",
                    emptySet()
                ) ?: emptySet()
            )
        }
    }

    var saved by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        TextButton(onClick = onBack) {
            Text("← Back to Home")
        }

        Text(
            text = "Meeting Scheduler",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "SIA Chapter Meeting",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Select all the times you are available."
        )

        Text(
            text = "Tap a box to select or deselect it.",
            style = MaterialTheme.typography.bodySmall
        )

        Column(
            modifier = Modifier.horizontalScroll(
                rememberScrollState()
            ),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                Spacer(modifier = Modifier.width(76.dp))

                days.forEach { day ->
                    Text(
                        text = day.take(3),
                        modifier = Modifier.width(55.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            times.forEach { time ->

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {

                    Text(
                        text = time,
                        modifier = Modifier.width(76.dp),
                        style = MaterialTheme.typography.labelSmall
                    )

                    days.forEach { day ->

                        val slot = "$day-$time"
                        val isSelected =
                            selectedSlots.contains(slot)

                        Box(
                            modifier = Modifier
                                .width(55.dp)
                                .height(45.dp)
                                .background(
                                    color = if (isSelected) {
                                        Color(0xFF2E7D32)
                                    } else {
                                        MaterialTheme.colorScheme
                                            .surfaceVariant
                                    },
                                    shape = MaterialTheme.shapes.small
                                )
                                .clickable {
                                    if (isSelected) {
                                        selectedSlots.remove(slot)
                                    } else {
                                        selectedSlots.add(slot)
                                    }
                                    saved = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            if (isSelected) {
                                Text(
                                    text = "✓",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }

        Text(
            text = "${selectedSlots.size} time slots selected",
            style = MaterialTheme.typography.titleMedium
        )

        Button(
            onClick = {
                preferences.edit()
                    .putStringSet(
                        "sia_meeting_slots",
                        selectedSlots.toSet()
                    )
                    .apply()

                saved = true
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save My Availability")
        }

        if (saved) {
            Text(
                text = "Availability saved successfully!",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

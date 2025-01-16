package com.example.carebeat.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import com.example.carebeat.screen.components.rememberMarker
import com.patrykandpatrick.vico.compose.cartesian.CartesianChartHost
import com.patrykandpatrick.vico.compose.cartesian.axis.rememberStart
import com.patrykandpatrick.vico.compose.cartesian.layer.rememberLineCartesianLayer
import com.patrykandpatrick.vico.compose.cartesian.marker.rememberDefaultCartesianMarker
import com.patrykandpatrick.vico.compose.cartesian.rememberCartesianChart
import com.patrykandpatrick.vico.compose.cartesian.rememberVicoScrollState
import com.patrykandpatrick.vico.core.cartesian.Scroll
import com.patrykandpatrick.vico.core.cartesian.axis.HorizontalAxis
import com.patrykandpatrick.vico.core.cartesian.axis.VerticalAxis
import com.patrykandpatrick.vico.core.cartesian.data.CartesianLayerModel
import com.patrykandpatrick.vico.core.cartesian.data.columnSeries
import com.patrykandpatrick.vico.core.cartesian.data.lineSeries
import com.patrykandpatrick.vico.core.cartesian.marker.CartesianMarker
import com.patrykandpatrick.vico.core.common.Fill
import com.patrykandpatrick.vico.core.common.component.LineComponent
import com.patrykandpatrick.vico.core.common.component.TextComponent
import com.patrykandpatrick.vico.core.common.shape.MarkerCorneredShape
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val modelProducer = viewModel.modelProducer
    val coroutineScope = rememberCoroutineScope()
    var chartData = remember { mutableStateListOf<Int>() }
    val scrollState = rememberVicoScrollState()
    val beatData by viewModel.beatDataState.collectAsState()
    Box(
        modifier = modifier
    ) {
        ElevatedButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .offset(y = (-50).dp)
        ) {
            Text("Start Monitoring")
        }
    }

    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        CartesianChartHost(
            rememberCartesianChart(
                rememberLineCartesianLayer(),
                startAxis = VerticalAxis.start(
                    LineComponent(Fill(android.graphics.Color.BLUE), thicknessDp = 3f),
                    TextComponent()
                ),
                bottomAxis = HorizontalAxis.bottom(
                    LineComponent(Fill(android.graphics.Color.BLUE), thicknessDp = 3f),
                    TextComponent()
                ),
                marker = rememberMarker(),

            ),
            modelProducer
        )

        FilledTonalButton(
            onClick = {
//                chartData.clear()
//                for (i in 1..200) {
//                    chartData.add((0..20).random())
//                }
//                chartData.add((0..20).random())
//                coroutineScope.launch {
//                    modelProducer.runTransaction {
//                        lineSeries { series(chartData) }
//                    }
//                }
                viewModel.addNewData((0..20).random())
            }
        ) {
            Text("Change Data")
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.fillMaxSize()
    )
}
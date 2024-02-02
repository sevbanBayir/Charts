package com.hd.charts.app.demo

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.hd.charts.app.ScrollView
import com.hd.charts.barstackedchart.StackedBarChartView
import com.hd.charts.barstackedchart.StackedChartData
import com.hd.charts.common.ChartStyle
import com.hd.charts.common.model.ChartData

@Composable
fun AddStackedBarChartDemo() {

    ScrollView {
        // Default
        AddStackedBarChart()

        Spacer(modifier = Modifier.height(20.dp))

        // Custom colors
        val colors = listOf(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.secondary,
            MaterialTheme.colorScheme.tertiary
        )
        AddStackedBarChart(colors)
    }
}

@Composable
private fun AddStackedBarChart(colors: List<Color> = emptyList()) {

    val style = ChartStyle.stackedBar.apply {
        chartViewStyle {
            this.width = 250.dp
        }

        stackedBarChartStyle {
            this.colors = colors
        }
    }.build()


    val legendLabels = listOf(
        "Jan", "Feb", "Mar"
    )

    val labelPrefix = "$"
    val chartData = listOf(
        StackedChartData(
            label = "Cherry St.",
            data = ChartData.fromFloatList(
                listOf(8261.68f, 4810.34f, 1536.57f),
                prefix = labelPrefix
            )
        ),
        StackedChartData(
            label = "Strawberry Mall",
            data = ChartData.fromFloatList(
                listOf(7875.87f, 3126.58f, 2019.81f),
                prefix = labelPrefix
            )
        ),
        StackedChartData(
            label = "Peach St.",
            data = ChartData.fromFloatList(
                listOf(4990.23f, 4923.48f, 1472.59f),
                prefix = labelPrefix
            )
        ),
        StackedChartData(
            label = "Lime Av.",
            data = ChartData.fromFloatList(
                listOf(4658.42f, 2955.55f, 1390.55f),
                prefix = labelPrefix
            )
        ),
        StackedChartData(
            label = "Apple Rd.",
            data = ChartData.fromFloatList(listOf(3952f, 1858.46f, 917.9f), prefix = labelPrefix)
        )
    )


    StackedBarChartView(
        chartData = chartData,
        title = stringResource(id = com.hd.charts.R.string.bar_stacked_chart),
        legend = legendLabels,
        style = style
    )
}

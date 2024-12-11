package com.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CubicFunctionPlotPartThree {
    public void run() {
        //Get user inputs
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the coefficients for the cubic function (ax^3 + bx^2 + cx + d):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        System.out.print("d: ");
        double d = scanner.nextDouble();

        System.out.print("Enter the starting x value: ");
        int startX = scanner.nextInt();
        System.out.print("Enter the ending x value: ");
        int endX = scanner.nextInt();
        System.out.print("Enter the interval (step): ");
        int interval = scanner.nextInt();

        //Data series for the cubic function
        XYSeries series = new XYSeries("Cubic Function");

        //StringBuilder to store CSV data
        StringBuilder csvData = new StringBuilder("X,Y\n");

        for (int x = startX; x <= endX; x += interval) {
            double y = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
            series.add(x, y);
            stats.addValue(y);
            csvData.append(x).append(",").append(y).append("\n");
        }

        //Save CSV data to Desktop
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String csvFileName = desktopPath + "cubic_function_points.csv";
        try (FileWriter writer = new FileWriter(csvFileName)) {
            writer.write(csvData.toString());
            System.out.println("\nCSV file saved on Desktop as: " + csvFileName);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }

        //Create dataset and chart
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory.createXYLineChart(
                "Cubic Function Plot",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        //Save chart as PNG on Desktop
        String chartFileName = desktopPath + "cubic_function_plot.png";
        try {
            ChartUtils.saveChartAsPNG(new File(chartFileName), chart, 800, 600);
            System.out.println("\nGraph saved on Desktop as: " + chartFileName);
        } catch (IOException e) {
            System.out.println("Error saving chart as image: " + e.getMessage());
        }

        //Display the chart in a Swing window
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cubic Function Plot");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new ChartPanel(chart));
            frame.pack();
            frame.setVisible(true);
        });

        scanner.close();
    }
}

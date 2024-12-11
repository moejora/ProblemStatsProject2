package com.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class CubicFunctionPartOne {
    public void run() {
        // Get user inputs
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

        // Data series for the cubic function
        DescriptiveStatistics stats = new DescriptiveStatistics();

        // StringBuilder to store CSV data
        StringBuilder csvData = new StringBuilder("X,Y\n");

        for (int x = startX; x <= endX; x += interval) {
            double y = a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d;
            stats.addValue(y);
            csvData.append(x).append(",").append(y).append("\n");
        }

        // Save CSV data to Desktop
        String desktopPath = System.getProperty("user.home") + "/Desktop/";
        String csvFileName = desktopPath + "cubic_function_stats.csv";
        try (FileWriter writer = new FileWriter(csvFileName)) {
            writer.write(csvData.toString());
            System.out.println("\nCSV file saved on Desktop as: " + csvFileName);
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }

        scanner.close();
    }
}

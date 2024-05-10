import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        String fileName = "C:\\input.txt";
        readFileAndUseNumber(fileName);
        createGraph();
    }
    public static boolean readFileAndUseNumber(String file) throws Exception {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        try {
            Scanner scanner = new Scanner(new File(file));
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    int number = scanner.nextInt();
                    listOfNumbers.add(number);
                } else {
                    scanner.next();
                }
            }
            scanner.close();
            System.out.printf("Максимальный: %d\n", _max(listOfNumbers));
            System.out.printf("Минимальный: %d\n", _min(listOfNumbers));
            System.out.printf("Сумма: %d\n", _sum(listOfNumbers));
            System.out.printf("Произведение: %d\n", _mult(listOfNumbers));
            return true;
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
    public static long _min(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int number : list) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }
    public static long _max(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int number : list) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
    public static long _sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        return sum;
    }
    public static long _mult(ArrayList<Integer> list) {
        int mult = 1;
        for (int number : list) {
            mult *= number;
        }
        return mult;
    }

    public static void createGraph() throws Exception {
        long startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input1.txt");
        long stopTime = System.currentTimeMillis();
        long elapsedTime1 = stopTime - startTime;
        System.out.println("Время программы работы с 100 числами - " + elapsedTime1);
        startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input2.txt");
        stopTime = System.currentTimeMillis();
        long elapsedTime2 = stopTime - startTime;
        System.out.println("Время программы работы с 10000 числами - " + elapsedTime2);
        startTime = System.currentTimeMillis();
        Main.readFileAndUseNumber("C:\\input3.txt");
        stopTime = System.currentTimeMillis();
        long elapsedTime3 = stopTime - startTime;
        System.out.println("Время программы работы с 100000 числами - " + elapsedTime3);
        XYSeries series = new XYSeries("Время программы");
        series.add(1, elapsedTime1);
        series.add(2, elapsedTime2);
        series.add(3, elapsedTime3);

        XYDataset xyDataset = new XYSeriesCollection(series);
        JFreeChart chart = ChartFactory
                .createXYLineChart("", "n", "t",
                        xyDataset,
                        PlotOrientation.VERTICAL,
                        true, true, true);
        JFrame frame =
                new JFrame("MinimalStaticChart");
        frame.getContentPane()
                .add(new ChartPanel(chart));
        frame.setSize(400,300);
        frame.show();
    }
}
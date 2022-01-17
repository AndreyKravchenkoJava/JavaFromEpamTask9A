package project;

import java.io.*;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class MainClass {
    public static void main(String[] args) throws FileException {
        try {
            File file = new File("Text");
            Scanner scanner = new Scanner(file);
            String line = scanner.nextLine();
            String[] numbersString = line.split("\\s");
            double[] numbers = new double[5];
            int counter = 0;
            for (String number : numbersString) {
                numbers[counter++] = Double.parseDouble(number);
            }

            System.out.println("Numbers: " + Arrays.toString(numbers));
            System.out.println("-----------------------------------");

            double sum = DoubleStream.of(numbers).sum();

            System.out.println("Sum all numbers: " + sum);
            System.out.println("-----------------------------------");

            double midCount = sum / 2;
            System.out.println("Middle count numbers: " + midCount);
            System.out.println("-----------------------------------");

            OptionalDouble midCount2 = DoubleStream.of(numbers).average();
            System.out.println("Middle count numbers 2: " + midCount2);

        } catch (FileNotFoundException e) {
            System.err.println("Файл не был найден!");
            throw new FileException(System.err.toString());
        } catch (NumberFormatException e) {
            throw new FileException("Привышено значение чила!");
        }
    }
}
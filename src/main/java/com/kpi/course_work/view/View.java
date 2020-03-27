package com.kpi.course_work.view;

import java.util.Scanner;

public class View {

    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public void printText() {
        System.out.println();
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public void printError(String error) {
        System.err.println(error);
    }

    public void printString(String str) {
        System.out.print(str);
    }

    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.printf("%4d", element);
            }
            printText();
        }
    }

    public String readDataFromConsole() {
        return scanner.next();
    }
}

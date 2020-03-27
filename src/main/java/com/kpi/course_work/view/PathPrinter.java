package com.kpi.course_work.view;

public class PathPrinter {

    private static void printPath(int[][] path, int v, int u) {
        if (path[v][u] == v)
            return;

        printPath(path, v, path[v][u]);
        System.out.print(path[v][u] + " ");
    }

    public static void printSolution(int[][] cost, int[][] path, int size) {
        for (int v = 0; v < size; v++) {
            for (int u = 0; u < size; u++) {
                if (u != v && path[v][u] != -1) {
                    System.out.print("Shortest Path from vertex " + v + " to vertex " + u + " is (" + v + " ");
                    printPath(path, v, u);
                    System.out.println(u + ")");
                }
            }
        }
    }
}

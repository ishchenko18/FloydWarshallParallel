package com.kpi.course_work.controller;

public class AdjacencyMatrixGenerator {

    public static int[][] generate(int size) {

        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (Math.random() * 100);
            }
        }

        return matrix;
    }
}

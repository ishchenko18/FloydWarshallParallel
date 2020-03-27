package com.kpi.course_work.model.general;

public abstract class AbstractFloydWarshall {

    public abstract Response findShortestPaths(int[][] adjMatrix, int size);

    protected void initialize(int[][] costs, int[][] paths, int[][] adjMatrix) {

        int size = adjMatrix.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                costs[i][j] = adjMatrix[i][j];

                if (i == j) {
                    paths[i][j] = 0;
                } else if (costs[i][j] != Integer.MAX_VALUE) {
                    paths[i][j] = i;
                } else {
                    paths[i][j] = -1;
                }
            }
        }
    }
}

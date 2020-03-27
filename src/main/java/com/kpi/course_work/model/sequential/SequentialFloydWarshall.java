package com.kpi.course_work.model.sequential;

import com.kpi.course_work.model.general.AbstractFloydWarshall;
import com.kpi.course_work.model.general.Response;

public class SequentialFloydWarshall extends AbstractFloydWarshall {

    @Override
    public Response findShortestPaths(int[][] adjMatrix, int size) {

        int[][] costs = new int[size][size];
        int[][] paths = new int[size][size];

        initialize(costs, paths, adjMatrix);

        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {

                    if (costs[i][k] != Integer.MAX_VALUE
                            && costs[k][j] != Integer.MAX_VALUE
                            && (costs[i][k] + costs[k][j] < costs[i][j])) {

                        costs[i][j] = costs[i][k] + costs[k][j];
                        paths[i][j] = paths[k][j];
                    }
                }
            }
        }

        return Response.of(costs, paths);
    }
}

package com.kpi.course_work.model.parallel;

public class FloydWarshallTask implements Runnable {

    private int vertex;
    private SynchronizedResult result;

    public FloydWarshallTask(int vertex, SynchronizedResult result) {
        this.vertex = vertex;
        this.result = result;
    }

    @Override
    public void run() {

        int[][] costs = result.getCosts();
        int[][] paths = result.getPaths();

        int size = costs.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (costs[i][vertex] != Integer.MAX_VALUE && costs[vertex][j] != Integer.MAX_VALUE
                        && (costs[i][vertex] + costs[vertex][j] < costs[i][j])) {

                    result.setCost(i, j, costs[i][vertex] + costs[vertex][j]);
                    result.setPath(i, j, paths[vertex][j]);
                }
            }
        }
    }
}

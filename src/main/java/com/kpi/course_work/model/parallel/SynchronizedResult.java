package com.kpi.course_work.model.parallel;

public class SynchronizedResult {

    private volatile int[][] costs;
    private volatile int[][] paths;

    public SynchronizedResult(int size) {
        this.costs = new int[size][size];
        this.paths = new int[size][size];
    }

    public synchronized void setCost(int i, int j, int value) {
        costs[i][j] = value;
    }

    public synchronized void setPath(int i, int j, int value) {
        paths[i][j] = value;
    }

    public int[][] getCosts() {
        return costs;
    }

    public int[][] getPaths() {
        return paths;
    }

    public int getSize() {
        return costs.length;
    }
}

package com.kpi.course_work.model.parallel;

import com.kpi.course_work.model.general.AbstractFloydWarshall;
import com.kpi.course_work.model.general.Response;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelFloydWarshall extends AbstractFloydWarshall {

    @Override
    public Response findShortestPaths(int[][] adjMatrix, int size) {

        SynchronizedResult result = new SynchronizedResult(size);

        initialize(result.getCosts(), result.getPaths(), adjMatrix);
        ExecutorService executorService = Executors.newFixedThreadPool(calculateAmountOfThreads(size));

        for (int k = 0; k < size; k++) {
            executorService.submit(new FloydWarshallTask(k, result));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
        executorService.shutdownNow();

        return Response.of(result.getCosts(), result.getPaths());
    }

    private int calculateAmountOfThreads(int size) {
        return (int) Math.ceil((double) size / 4);
    }
}

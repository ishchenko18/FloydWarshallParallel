package com.kpi.course_work.controller;

import com.kpi.course_work.model.general.FloydWarshallResult;
import com.kpi.course_work.model.general.Response;
import com.kpi.course_work.model.parallel.ParallelFloydWarshall;
import com.kpi.course_work.model.sequential.SequentialFloydWarshall;

import java.nio.file.Paths;

public class Controller {

    private SequentialFloydWarshall sequentialFloydWarshall;
    private ParallelFloydWarshall parallelFloydWarshall;

    public Controller() {
        sequentialFloydWarshall = new SequentialFloydWarshall();
        parallelFloydWarshall = new ParallelFloydWarshall();
    }

    public FloydWarshallResult solveTask(int wayOfInitialization, int size) throws Exception {

        int[][] adjMatrix;

        switch (wayOfInitialization) {
            case 1:
                adjMatrix = Reader.readAdjacencyMatrix(Paths.get("src/main/resources/input.txt"));
                break;
            case 2:
                adjMatrix = AdjacencyMatrixGenerator.generate(size);
                break;
            default:
                throw new IllegalArgumentException("Incorrect way of initialization.");
        }

        long sequentialStartTime = System.nanoTime();
        Response sequentialResponse = sequentialFloydWarshall.findShortestPaths(adjMatrix, adjMatrix.length);
        long sequentialEndTime = System.nanoTime();

        long parallelStartTime = System.nanoTime();
        Response parallelResponse = parallelFloydWarshall.findShortestPaths(adjMatrix, adjMatrix.length);
        long parallelEndTime = System.nanoTime();

        double seqTime = ((double) sequentialEndTime - sequentialStartTime) / 1_000_000;
        double parTime = ((double) parallelEndTime - parallelStartTime) / 1_000_000;

        return new FloydWarshallResult()
                .durationSequential(seqTime)
                .durationParallel(parTime)
                .adjacencyMatrix(adjMatrix)
                .sequentialResponse(sequentialResponse)
                .parallelResponse(parallelResponse);
    }
}

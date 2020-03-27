package com.kpi.course_work.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {

    public static int[][] readAdjacencyMatrix(Path path) throws IOException {

        List<String> lines = Files.readAllLines(path);

        if (lines.isEmpty()) {
            throw new IllegalStateException(String.format("File by path %s is empty.", path));
        }

        int size = Integer.parseInt(lines.remove(0));
        int[][] adjacencyMatrix = new int[size][size];

        List<List<Integer>> values = lines.stream()
                .map(l -> Arrays.stream(l.split("\\s"))
                        .map(e -> Integer.valueOf(e.trim()))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());

        if (values.size() != size || values.stream().anyMatch(row -> row.size() != size)) {
            throw new IllegalArgumentException("Size from input file doesn't match with size of matrix.");
        }

        for (int i = 0; i < values.size(); i++) {
            List<Integer> row = values.get(i);
            for (int j = 0; j < row.size(); j++) {
                int element = row.get(j);
                adjacencyMatrix[i][j] = element == 0 ? Integer.MAX_VALUE : element;
            }
        }

        return adjacencyMatrix;
    }
}

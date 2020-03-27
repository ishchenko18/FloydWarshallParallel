package com.kpi.course_work;

import com.kpi.course_work.controller.Controller;
import com.kpi.course_work.model.general.FloydWarshallResult;
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4ClassRunner.class)
public class E2ETests {

    private Controller controller;

    @Before
    public void setUp() {
        controller = new Controller();
    }

    @Test
    public void solveTaskWithRandomGenerationOfMatrixSizeIs10() throws Exception {

        FloydWarshallResult result = controller.solveTask(2, 10);

        assertTrue(checkMatricesAreEqual(result.getParallelResponse().getCosts(), result.getSequentialResponse().getCosts()));
    }

    @Test
    public void solveTaskWithRandomGenerationOfMatrixSizeIs500() throws Exception {

        FloydWarshallResult result = controller.solveTask(2, 500);

        assertTrue(checkMatricesAreEqual(result.getParallelResponse().getCosts(), result.getSequentialResponse().getCosts()));
    }

    @Test
    public void solveTaskWithRandomGenerationOfMatrixSizeIs1000() throws Exception {

        FloydWarshallResult result = controller.solveTask(2, 1000);

        assertTrue(checkMatricesAreEqual(result.getParallelResponse().getCosts(), result.getSequentialResponse().getCosts()));
    }

    @Test
    public void solveTaskWithRandomGenerationOfMatrixSizeIs2000() throws Exception {

        FloydWarshallResult result = controller.solveTask(2, 2000);

        assertTrue(checkMatricesAreEqual(result.getParallelResponse().getCosts(), result.getSequentialResponse().getCosts()));
    }

    @Test
    public void solveTaskWithRandomGenerationOfMatrixSizeIs4000() throws Exception {

        FloydWarshallResult result = controller.solveTask(2, 4000);

        assertTrue(checkMatricesAreEqual(result.getParallelResponse().getCosts(), result.getSequentialResponse().getCosts()));
    }

    public boolean checkMatricesAreEqual(int[][] first, int[][] second) {
        boolean equal = true;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                if (first[i][j] != second[i][j]) {
                    equal = false;
                    System.err.println(first[i][j] + " != " + second[i][j]);
                }
            }
        }

        return equal;
    }
}

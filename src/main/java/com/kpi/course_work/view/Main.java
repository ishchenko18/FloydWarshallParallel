package com.kpi.course_work.view;

import com.kpi.course_work.controller.Controller;
import com.kpi.course_work.model.general.FloydWarshallResult;

public class Main {

    public static void main(String[] args) throws Exception {

        View view = new View();
        Controller controller = new Controller();
        view.printText("Select way of initialization: ");
        view.printText("\t1 - Read from file.");
        view.printText("\t2 - Generate randomly.");

        view.printString("Enter your variant: ");
        int wayOfInitialization = Integer.parseInt(view.readDataFromConsole());
        view.printText();

        if (wayOfInitialization > 2 || wayOfInitialization < 1) {
            view.printError("Chose way of initialization is incorrect. Please, select one of the provided variant.");
            return;
        }

        int matrixSize = 0;

        if (wayOfInitialization == 2) {
            view.printString("Enter size of matrix: ");
            matrixSize = Integer.parseInt(view.readDataFromConsole());
            view.printText();

            if (matrixSize < 1) {
                view.printError("Size of matrix should be positive value.");
                return;
            }
        }

        FloydWarshallResult result = controller.solveTask(wayOfInitialization, matrixSize);

        if (result.getAdjacencyMatrix().length <= 10) {
            view.printText("Input matrix: ");
            view.printMatrix(result.getAdjacencyMatrix());
            view.printText();

            view.printText("Distances matrix found by sequential FW: ");
            view.printMatrix(result.getSequentialResponse().getCosts());
            view.printText();

            view.printText("Distances matrix found by parallel FW: ");
            view.printMatrix(result.getParallelResponse().getCosts());
            view.printText();
        }

        view.printText(String.format("Sequential time: %s", result.getDurationSequential()));
        view.printText(String.format("Parallel time: %s", result.getDurationParallel()));
    }
}

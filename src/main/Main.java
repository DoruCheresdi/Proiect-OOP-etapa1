package main;

import checker.Checker;
import common.Constants;
import common.SimulationConstants;
import data.SimulationData;
import fileio.InputReader;
import simulation.Simulation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }

    /**
     * Method to read, solve and write data for one test
     * @param inputFile
     * @param outputFile
     * @throws IOException
     */
    public static void solveOneTest(final File inputFile, final File outputFile)
            throws IOException {
        // empty the database:
        SimulationData simulationData = SimulationData.getInstance();
        simulationData.emptyData();
        simulationData = SimulationData.getInstance();

        // load test data into database:
        InputReader inputReader = new InputReader(inputFile.getAbsolutePath());
        inputReader.readData();

        // TODO start simulation:


        // TODO write simulation result JSON to output file:

    }

    /**
     * function to solve all tests
     */
    public static void solveTests() throws IOException {
        // checks if output directory exists, if not then create it:
        Path outPath = Paths.get(SimulationConstants.OUTPUT_DIR_PATH);
        if (!Files.exists(outPath)) {
            Files.createDirectories(outPath);
        }

        // delete all previous out files:
        File outputDirectory = new File(SimulationConstants.OUTPUT_DIR_PATH);
        for (File file : Objects.requireNonNull(outputDirectory.listFiles())) {
            if (!file.delete()) {
                System.out.println("File can't be deleted.");
            }
        }

        // solve each test:
        File inputDir = new File(SimulationConstants.INPUT_DIR_PATH);
        for (File inputFile : Objects.requireNonNull(inputDir.listFiles())) {
            String outputPathString = Constants.OUTPUT_PATH
                    + inputFile.getName();
            File outputFile = new File(outputPathString);
            boolean hasBeenCreated = outputFile.createNewFile();
            if (hasBeenCreated) {
                solveOneTest(inputFile, outputFile);
//                System.out.println(inputFile.getName() + " " + outputFile.getName());
            }
        }
    }

    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        solveTests();

        Checker.calculateScore();
    }
}

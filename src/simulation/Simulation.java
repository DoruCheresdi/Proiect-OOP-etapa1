package simulation;

import children.Child;
import data.SimulationData;
import fileio.Writer;
import org.json.simple.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Writer writer;

    public Simulation(Writer writer) {
        this.writer = writer;
    }

    /**
     * Function that simulates the gift giving to children and creates the
     * output JSON
     */
    public void simulate() throws IOException {
        SimulationData simulationData = SimulationData.getInstance();
        int numberOfYears = simulationData.getNumberOfYears();
        for (int year = 0; year <= numberOfYears; year++) {
            if (year != 0) {
                // update simulation data for a certain year:
                SimulationUpdater simulationUpdater = new SimulationUpdater();
                simulationUpdater.updateSimulation(year);
            } else {
                removeAdults();
            }

            // assign budget to children
            NiceScoreCalculator niceScoreCalculator = new NiceScoreCalculator();
            niceScoreCalculator.calculateNiceScore();

            BudgetCalculator budgetCalculator = new BudgetCalculator();
            budgetCalculator.calculateBudget();

            // assign gifts to children
            GiftGiver giftGiver = new GiftGiver();
            giftGiver.giveGiftsToChildren();

            // add children list to output json
            JSONArray yearlyChildrenJSON = new JSONArray();
            for (Child child :
                    simulationData.getChildren()) {
                yearlyChildrenJSON.add(writer.addChildToJson(child));
            }
            writer.addChildrenJsonToOutput(yearlyChildrenJSON);
        }
    }

    private void removeAdults() {
        SimulationData simulationData = SimulationData.getInstance();
        List<Child> childrenToRemove = new ArrayList<>();
        for (Child child :
                simulationData.getChildren()) {
            Integer age = child.getAge();
            if (age > 18) {
                childrenToRemove.add(child);
            }
        }
        simulationData.getChildren().removeAll(childrenToRemove);
    }

}

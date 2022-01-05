package simulation;

import children.Child;
import data.SimulationData;
import enums.ChildType;
import simulation.scorestrategy.NiceScoreStrategy;
import simulation.scorestrategy.NiceScoreStrategyFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NiceScoreCalculator {
    /**
     * Method to calculate average niceScore for all children
     */
    public void calculateNiceScore() {
        SimulationData simulationData = SimulationData.getInstance();

        // calculate individual average nice score:
        for (Child child
                : simulationData.getChildren()) {
            // create strategy using factory pattern
            ChildType childType = child.determineType();
            NiceScoreStrategyFactory niceScoreStrategyFactory = new NiceScoreStrategyFactory();
            NiceScoreStrategy niceScoreStrategy =
                    niceScoreStrategyFactory.getNiceScoreStrategy(childType);


            // use strategy using strategy pattern
            niceScoreStrategy.calculateScore(child);
        }
    }
}
package simulation.scorestrategy;

import children.Child;

public class BabyStrategy implements NiceScoreStrategy {
    @Override
    public void calculateScore(Child child) {
        child.setAverageScore(10d);
    }
}

package simulation.scorestrategy;

import children.Child;

import java.util.List;

public class KidStrategy implements NiceScoreStrategy {
    @Override
    public void calculateScore(Child child) {
        List<Double> scoreHistory = child.getNiceScoreHistory();

        // calculate average:
        Double sum = 0d;
        for (Double score :
                scoreHistory) {
            sum += score;
        }
        Double averageScore = sum / scoreHistory.size();

        child.setAverageScore(averageScore);
    }
}

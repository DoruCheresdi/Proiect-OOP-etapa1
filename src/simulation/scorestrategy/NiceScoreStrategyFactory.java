package simulation.scorestrategy;

import enums.ChildType;

public class NiceScoreStrategyFactory {
    public NiceScoreStrategy getNiceScoreStrategy(ChildType childType) {
        switch (childType) {
            case BABY: return new BabyStrategy();
            case KID: return new KidStrategy();
            case TEEN: return new TeenStrategy();
        }
        throw new IllegalArgumentException("This nice score strategy type is invalid");
    }
}

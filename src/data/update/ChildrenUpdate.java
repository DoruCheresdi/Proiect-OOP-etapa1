package data.update;

import enums.Category;

import java.util.List;

public class ChildrenUpdate {
    private Integer id;
    private Double niceScore;
    private List<Category> giftPreferences;

    public ChildrenUpdate(final Integer id, final Double niceScore, final List<Category> giftPreferences) {
        this.id = id;
        this.niceScore = niceScore;
        this.giftPreferences = giftPreferences;
    }
}

package children;

import enums.Category;
import enums.Cities;

import java.util.List;

public class Child {
    private Integer id;
    private Integer age;
    private String lastName;
    private String firstName;
    private Cities city;
    private Double niceScore;
    private List<Category> preferences;

    public Child(final Integer id, final Integer age, final String lastName,
                 final String firstName, final Cities city,
                 final Double niceScore, List<Category> preferences) {
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        this.niceScore = niceScore;
        this.preferences = preferences;
    }
}

package children;

import enums.Category;
import enums.ChildType;
import enums.ChildType;
import enums.Cities;
import gifts.Gift;

import java.util.ArrayList;
import java.util.List;

public class Child {
    private Integer id;
    private Integer age;
    private String lastName;
    private String firstName;
    private Cities city;
    private List<Double> niceScoreHistory;
    private Double averageScore;
    private Double assignedBudget;
    private List<Category> preferences;
    private List<Gift> receivedGifts;

    public Child(final Integer id, final Integer age, final String lastName,
                 final String firstName, final Cities city,
                 final Double niceScore, List<Category> preferences) {
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
        niceScoreHistory = new ArrayList<>();
        niceScoreHistory.add(niceScore);
        this.preferences = preferences;
    }

    /**
     * Method to determine type of child
     * @return
     */
    public ChildType determineType() {
        if (age < 5) {
            return ChildType.BABY;
        }
        if (age >= 12) {
            return ChildType.TEEN;
        }
        return ChildType.KID;
    }

    /**
     * Method that determines if a child is and adult
     * @return
     */
    public boolean isAdult() {
        return age > 18;
    }

    /**
     * Method to determine if a child has a certain preference
     * @param preference
     * @return
     */
    public boolean hasPreference(Category preference) {
        return preferences.contains(preference);
    }

    /**
     * getter
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter
     * @param id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * getter
     * @return
     */
    public Integer getAge() {
        return age;
    }

    /**
     * setter
     * @param age
     */
    public void setAge(final Integer age) {
        this.age = age;
    }

    /**
     * getter
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter
     * @param lastName
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * getter
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * setter
     * @param firstName
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * getter
     * @return
     */
    public Cities getCity() {
        return city;
    }

    /**
     * setter
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * getter
     * @return
     */
    public List<Double> getNiceScoreHistory() {
        return niceScoreHistory;
    }

    /**
     * setter
     * @param niceScoreHistory
     */
    public void setNiceScoreHistory(final List<Double> niceScoreHistory) {
        this.niceScoreHistory = niceScoreHistory;
    }

    /**
     * getter
     * @return
     */
    public Double getAverageScore() {
        return averageScore;
    }

    /**
     * setter
     * @param averageScore
     */
    public void setAverageScore(final Double averageScore) {
        this.averageScore = averageScore;
    }

    /**
     * getter
     * @return
     */
    public Double getAssignedBudget() {
        return assignedBudget;
    }

    /**
     * setter
     * @param assignedBudget
     */
    public void setAssignedBudget(final Double assignedBudget) {
        this.assignedBudget = assignedBudget;
    }

    /**
     * getter
     * @return
     */
    public List<Category> getPreferences() {
        return preferences;
    }

    /**
     * setter
     * @param preferences
     */
    public void setPreferences(final List<Category> preferences) {
        this.preferences = preferences;
    }

    /**
     * getter
     * @return
     */
    public List<Gift> getReceivedGifts() {
        return receivedGifts;
    }

    /**
     * setter
     * @param receivedGifts
     */
    public void setReceivedGifts(final List<Gift> receivedGifts) {
        this.receivedGifts = receivedGifts;
    }
}

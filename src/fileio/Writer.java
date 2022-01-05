package fileio;

import children.Child;
import common.SimulationConstants;
import enums.Category;
import gifts.Gift;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import simulation.Simulation;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Writer {
    private FileWriter fileWriter;
    private JSONObject jsonOutputObject;
    private JSONArray jsonOutputArray;
    public Writer(final String outputPath) throws IOException {
        fileWriter = new FileWriter(outputPath);
        jsonOutputArray = new JSONArray();
    }

    /**
     * Method to add one child to the output JSON
     * @param child
     * @return
     */
    public JSONObject addChildToJson(Child child) {
        JSONObject childJson = new JSONObject();
        childJson.put(SimulationConstants.ID, child.getId());
        childJson.put(SimulationConstants.LAST_NAME, child.getLastName());
        childJson.put(SimulationConstants.FIRST_NAME, child.getFirstName());
        childJson.put(SimulationConstants.CITY, child.getCity().getValue());
        childJson.put(SimulationConstants.AGE, child.getAge());

        ArrayList<String> preferencesString = new ArrayList<>();
        for (Category preference :
                child.getPreferences()) {
            preferencesString.add(preference.getValue());
        }
        childJson.put(SimulationConstants.GIFT_PREFERENCES, preferencesString);

        childJson.put(SimulationConstants.AVERAGE_SCORE, child.getAverageScore());
        childJson.put(SimulationConstants.NICE_SCORE_HISTORY, child.getNiceScoreHistory());
        childJson.put(SimulationConstants.ASSIGNED_BUDGET, child.getAssignedBudget());

        JSONArray receivedGiftsJsonArray = new JSONArray();
        for (Gift gift :
                child.getReceivedGifts()) {
            JSONObject receivedGiftJson = new JSONObject();
            receivedGiftJson.put(SimulationConstants.PRODUCT_NAME, gift.getProductName());
            receivedGiftJson.put(SimulationConstants.PRICE, gift.getPrice());
            receivedGiftJson.put(SimulationConstants.CATEGORY, gift.getCategory().getValue());

            receivedGiftsJsonArray.add(receivedGiftJson);
        }
        childJson.put(SimulationConstants.RECEIVED_GIFTS, receivedGiftsJsonArray);


        return childJson;
    }

    public void addChildrenJsonToOutput(final JSONArray childrenJsonArray) {
        JSONObject jsonChildrenWrapper = new JSONObject();
        jsonChildrenWrapper.put(SimulationConstants.CHILDREN, childrenJsonArray);
        jsonOutputArray.add(jsonChildrenWrapper);
    }

    /**
     * Method to write contents of the jsonOutputObject int the output file
     */
    public void writeToFile() {
        // adding the children JSON array to output JSON:
        jsonOutputObject = new JSONObject();
        jsonOutputObject.put(SimulationConstants.ANNUAL_CHILDREN, jsonOutputArray);
        try {
            fileWriter.write(jsonOutputObject.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * getter
     * @return
     */
    public JSONObject getJsonOutputObject() {
        return jsonOutputObject;
    }

    /**
     * setter
     * @param jsonOutputObject
     */
    public void setJsonOutputObject(final JSONObject jsonOutputObject) {
        this.jsonOutputObject = jsonOutputObject;
    }
}

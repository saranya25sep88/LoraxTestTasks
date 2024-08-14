package items;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CostAnalysisItem {
    @JsonProperty("yearId")
    private String yearId;

    @JsonProperty("geoRegionId")
    private int geoRegionId;

    @JsonProperty("countryId")
    private int countryId;

    @JsonProperty("regionId")
    private int regionId;
    @JsonProperty("schemeId")
    private int schemeId;
    @JsonProperty("schmTypeId")
    private int schmTypeId;
    @JsonProperty("cost")
    private double cost;

    // Getters and Setters
    public String getYearId() {
        return yearId;
    }

    public void setYearId(String yearId) {
        this.yearId = yearId;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

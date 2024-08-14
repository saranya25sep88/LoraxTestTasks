import items.CostAnalysisItem;
import items.JSONDeserializer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSONTest {

//    deserializer is kept at class level to access across diff test methods and reduce redundancy
    JSONDeserializer deserializer = new JSONDeserializer();
    List<CostAnalysisItem> items;

    // This method is run before each test to initialize the 'items' list
    @BeforeEach
    public void setUp() throws IOException {
        items = deserializer.deserializeJSON();
    }

    // Test to verify the list contains the expected number of items
    @Test
    public void testItemSize() throws IOException {
        // Assert that the list contains the expected number of items
        assertEquals(53, items.size(), "The list should contain 63 items.");
    }

    // Test to assert the countryId of the item with the highest cost (using streams for sorting and filtering)
    @Test
    public void testAssertCountryIdForTheTopItem() throws IOException {

        List<CostAnalysisItem> filterSortedItems =
                items.stream().sorted(Comparator.comparing(CostAnalysisItem::getCost).reversed()) // sort by cost in descending order
                        .collect(Collectors.toList());

        CostAnalysisItem topItem = filterSortedItems.stream()
                .findFirst() // Get the first element from the sorted list
                .orElseThrow(() -> new AssertionError("No items found"));

        // Assert the countryId of the top item
        Assertions.assertEquals(0, topItem.getCountryId(), "CountryId does not match for the top item by cost");
    }


    // Test to calculate and verify the total cost of items for the year 2016 (using for loop)
    @Test
    public void testCalculateCost() throws IOException {
        double totalCost = 0.0;
        // for each loop to iterate over the list and sum up the costs for the year 2016
        for (CostAnalysisItem item : items) {
            if ("2016".equals(item.getYearId())) {
                totalCost += item.getCost();
            }
        }
        // Assert that the total cost matches the expected value
        Assertions.assertEquals(77911.3744561, totalCost, "Total cost for 2016 does not match");
    }
}
















//            for (int i=0;i<items.size();i++) {
//                CostAnalysisItem item = items.get(i);


//using stream
//        CostAnalysisItem topItem = items.stream()
//                .max(Comparator.comparingDouble(CostAnalysisItem::getCost))
//                .orElseThrow(() -> new AssertionError("No items found"));
//
//        Assertions.assertEquals(0, topItem.getCountryId(), "CountryId does not match for the top item by cost");
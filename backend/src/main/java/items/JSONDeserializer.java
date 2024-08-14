package items;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JSONDeserializer {
    private static final String JSON_FILE_PATH = "src/main/resources/JSON/CostAnalysis.json";

    public List<CostAnalysisItem> deserializeJSON() throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        // Read and deserialize JSON file into a java (CostAnalysisItem) object
        return mapper.readValue(new File(JSON_FILE_PATH), new TypeReference<List<CostAnalysisItem>>() {
        });
    }
}

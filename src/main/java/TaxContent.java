import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxContent {
    @JsonProperty("minPrice")
    Double minPrice;
    @JsonProperty("maxPrice")
    Double maxPrice;
    @JsonProperty("tax")
    Double tax;
    @JsonProperty("type")
    TaxType type;
}


import com.fasterxml.jackson.annotation.JsonProperty;

public class OutputModel {
    @JsonProperty("item")
    String item;
    @JsonProperty("basePrice")
    Double basePrice;
    @JsonProperty("finalPrice")
    Double finalPrice;
}

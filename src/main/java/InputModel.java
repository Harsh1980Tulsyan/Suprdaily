import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InputModel {
   @JsonProperty("item")
    String item;
   @JsonProperty("basePrice")
    Double basePrice;
   @JsonProperty("discount")
    Double discount;
}

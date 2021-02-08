import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxModel {
   @JsonProperty("taxA")
   TaxContent taxA;
   @JsonProperty("taxB")
   TaxContent  taxB;
   @JsonProperty("taxC")
   TaxContent  taxC;
}

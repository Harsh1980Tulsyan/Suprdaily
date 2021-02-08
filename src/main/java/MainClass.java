import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public void execute() {
        ObjectMapper objectMapper = new ObjectMapper();
        UtilityClass utilityClass = new UtilityClass();
        TaxCalculations taxCalculations = new TaxCalculations();

        try {

            //reading tax slab object
            Object taxSlabObject = utilityClass.readFile(Constant.TAX_SLAB_CONFIG);

            //converting object to tax model
            TaxModel taxModel = objectMapper.readValue(taxSlabObject.toString(), TaxModel.class);

            //reading input items object
            Object inputItemObject = utilityClass.readFile(Constant.INPUT_ITEM_MODEL);

            //Converting input item object to input model list
            ArrayList<InputModel> inputModelList = objectMapper.convertValue(inputItemObject, ArrayList.class);

            //Tax Calculation logic
            List<OutputModel> outputModelList = taxCalculations.calculateTax(inputModelList, taxModel);

            //Writing output to the file
            utilityClass.writeFile(outputModelList);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

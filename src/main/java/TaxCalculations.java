import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculations {

    ObjectMapper objectMapper = new ObjectMapper();
    List<OutputModel> outputList = new ArrayList<OutputModel>();

    public List<OutputModel> calculateTax(ArrayList<InputModel> inputModels, TaxModel taxModel) {

        //iterating via each input items
        for (int i = 0; i < inputModels.size(); i++) {
            InputModel models = objectMapper.convertValue(inputModels.get(i), InputModel.class);

            OutputModel outputModel = new OutputModel();

            double basePrice = models.basePrice;
            double discount = 0;
            if (models.discount != null) {
                discount = models.discount;
            }
            double taxPrice = 0;

            //Calculating discount
            double outPutDiscount = (basePrice * discount) / 100;

            //Tax slab taxA logic
            if (basePrice > taxModel.taxA.minPrice && basePrice <= taxModel.taxA.maxPrice) {

                if (taxModel.taxA.type.equals(TaxType.percentage)) {
                    taxPrice += (basePrice * taxModel.taxA.tax) / 100;

                } else
                    taxPrice += taxModel.taxA.tax;

                // Tax slab taxB logic..runs only when taxA if condition gets declined
            } else if (basePrice > taxModel.taxB.minPrice) {

                if (taxModel.taxB.type.equals(TaxType.percentage)) {
                    taxPrice += (basePrice * taxModel.taxB.tax) / 100;

                } else
                    taxPrice += taxModel.taxB.tax;
            }

            //taxC slab logic...runs for all
            if (basePrice > taxModel.taxC.minPrice) {

                if (taxModel.taxC.type.equals(TaxType.percentage)) {
                    taxPrice += (basePrice * taxModel.taxC.tax) / 100;

                } else
                    taxPrice += taxModel.taxC.tax;
            }

            // calculating final price
            double finalPrice = basePrice + taxPrice - outPutDiscount;
            outputModel.basePrice = basePrice;
            outputModel.item = models.item;
            outputModel.finalPrice = finalPrice;
            outputList.add(outputModel);
        }

        return outputList;
    }
}

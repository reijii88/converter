package interfaces;

import converter.ConvertationRequest;
import converter.ConvertionResult;

public interface IConverter {
//    ConvertionResult convert(double initialAmount, CURRENCY_ENUM inputCurrency, CURRENCY_ENUM outputCurrency);
    ConvertionResult convert(ConvertationRequest request);
}

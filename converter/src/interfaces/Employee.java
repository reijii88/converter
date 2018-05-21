package interfaces;

import converter.ConvertationRequest;
import converter.ConvertionData;
import exception.ConvertionException;

public interface Employee {
    public ConvertationRequest createConvertationRequest(ConvertionData data) throws ConvertionException;
    public boolean check(ConvertionData data);
}

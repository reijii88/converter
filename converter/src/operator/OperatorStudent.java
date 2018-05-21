package operator;

import converter.ConvertationRequest;
import converter.ConvertionData;
import enums.CURRENCY_ENUM;
import exception.ConvertionException;
import interfaces.Employee;
import person.Person;

public class OperatorStudent extends Person implements Employee {

    @Override
    public boolean check(ConvertionData data) {
        if (!data.getClient().getFullName().isEmpty() && data.getClient().getDul() != null
                && data.getInputAmount() <= 1000) {
            return true;
        }
        return false;
    }


    @Override
    public ConvertationRequest createConvertationRequest(ConvertionData data) throws ConvertionException {
        if(data.getInputCurrency().equals(CURRENCY_ENUM.EUR)){
            throw new ConvertionException("операция не доступнадля роли Студент");
        }
        System.out.println("LOG Заявка создана студентом");
        return new ConvertationRequest(data);
    }
}

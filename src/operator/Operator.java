package operator;

import converter.ConvertationRequest;
import converter.ConvertionData;
import exception.ConvertionException;
import interfaces.Employee;
import person.Person;

public class Operator extends Person implements Employee {

    public boolean check(ConvertionData data) {
        if (!data.getClient().getFullName().isEmpty() && data.getClient().getDul() != null) {
            return true;
        }
        return false;
    }

    @Override
    public ConvertationRequest createConvertationRequest(ConvertionData data) throws ConvertionException {
        if (data.getInputAmount() <= 0 && data.getInputCurrency() == null &&
                data.getRate() <= 0 &&
                data.getCashBox().getBalance(data.getOutputCurrency()) < data.getOutputAmount()) {
            throw new ConvertionException("Ошибка создания заявки");
        }
        System.out.println("LOG Заявка создана оператором");
        return new ConvertationRequest(data);
    }


}

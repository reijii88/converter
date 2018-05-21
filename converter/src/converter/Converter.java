package converter;

import cashbox.CashBox;
import client.Client;
import enums.CURRENCY_ENUM;
import enums.OperationResult;
import interfaces.IConverter;
import operator.Operator;
import operator.OperatorStudent;

public class Converter implements IConverter {

    private Client client;
    private Operator operator;
    private double rate;
    private ConvertionResult result;
    private CashBox cb;
    private OperatorStudent student;

//    public Converter(Client client, Operator operator) {
//        this.client = client;
//        this.operator = operator;
//        this.student = new OperatorStudent();
//        cb = CashBox.getInstance();
//        result = new ConvertionResult();
//    }

    public Converter() {
        result = new ConvertionResult();
    }

//    @Override
//    public ConvertionResult convert(double initialAmount, CURRENCY_ENUM inputCurrency, CURRENCY_ENUM outputCurrency) {
//        rate = CentralBankService.getCurrentRate(inputCurrency);
//        if (verification(initialAmount, inputCurrency, outputCurrency, rate)) {
//            operator.createConvertationRequest(client, initialAmount, inputCurrency,
//                    outputCurrency);
//
//            student.createConvertationRequest(client, initialAmount, inputCurrency,
//                    outputCurrency);
//
//        result.setOperationResult(OperationResult.SUCCESS);
//        result.setMsg("Операция выполнена успешно.");
//        double resultOperation = initialAmount * rate;
//        result.setResultAmount(resultOperation);
//        result.setInputAmount(initialAmount);
//        result.setInputCurrency(inputCurrency);
//        result.setRate(rate);
//        result.setClient(client);
//        result.setResultCurrency(outputCurrency);
//        result.setOperatorStatus(Operator.getPosition());
//        cb.operation(inputCurrency, initialAmount, outputCurrency);
//        return result;
//
//    }
//        result.setMsg("verificationError "+result.getMsg());
//        result.setOperationResult(OperationResult.ERROR);
//        return result;
//}

    @Override
    public ConvertionResult convert(ConvertationRequest request) {

        return new ConvertionResult(request.getClient(), request.getInputAmount(), request.getInputCyrrency(),
                request.getOutputAmount(), request.getOutputCyrrency(), request.getRate());
    }

//    private boolean verification(double initialAmount, CURRENCY_ENUM inputCurrency,
//                                 CURRENCY_ENUM outputCurrency, double rate) {
//
//        if (!operator.check(client).equals(OperationResult.SUCCESS)) {
//            result.setOperationResult(OperationResult.ERROR);
//            result.setMsg("Клиент не прошел проверку");
//            return false;
////        } else if (initialAmount >= 500) {
////            result.setOperationResult(OperationResult.ERROR);
////            result.setStatus("Student");
////            result.setMsg("Превышена сумма операции для роли СТУДЕНТ");
////            return false;
//        } else if (initialAmount < 0) {
//            result.setOperationResult(OperationResult.ERROR);
//            result.setMsg("Входящая сумма меньше 0");
//            return false;
//        } else if (inputCurrency == null && outputCurrency == null) {
//            result.setOperationResult(OperationResult.ERROR);
//            result.setMsg("Не указана валюта");
//            return false;
//        } else if (cb.getBalance(outputCurrency) <= 0) {
//            result.setOperationResult(OperationResult.ERROR);
//            result.setMsg("В кассе не достаточно средств");
//            return false;
//        } else if (!inputCurrency.equals(CURRENCY_ENUM.USD)
//                || inputCurrency.equals(CURRENCY_ENUM.RUB)
//                || inputCurrency.equals(CURRENCY_ENUM.EUR) && rate > 0) {
//            result.setOperationResult(OperationResult.ERROR);
//            result.setMsg("Нет запрашиваемой валюты");
//            return false;
//        }
//        result.setOperationResult(OperationResult.SUCCESS);
//        result.setStatus("Operator");
//        return true;
//    }
//

    private boolean verification(ConvertionData data) {

        if (!data.getOperator().check(data)) {
            result.setOperationResult(OperationResult.ERROR);
            result.setMsg("Клиент не прошел проверку");
            return false;
        } else if (data.getInputAmount() < 0) {
            result.setOperationResult(OperationResult.ERROR);
            result.setMsg("Входящая сумма меньше 0");
            return false;
        } else if (data.getInputCurrency() == null && data.getOutputCurrency() == null) {
            result.setOperationResult(OperationResult.ERROR);
            result.setMsg("Не указана валюта");
            return false;
        } else if (data.getCashBox().getBalance(data.getOutputCurrency()) <= 0) {
            result.setOperationResult(OperationResult.ERROR);
            result.setMsg("В кассе не достаточно средств");
            return false;
        } else if (!data.getInputCurrency().equals(CURRENCY_ENUM.USD)
                || data.getInputCurrency().equals(CURRENCY_ENUM.RUB)
                || data.getInputCurrency().equals(CURRENCY_ENUM.EUR) && rate > 0) {
            result.setOperationResult(OperationResult.ERROR);
            result.setMsg("Нет запрашиваемой валюты");
            return false;
        }
        result.setOperationResult(OperationResult.SUCCESS);
        return true;
    }


    public ConvertionResult convert(ConvertionData data) {
        if(verification(data) == true) {

            result.setOperationResult(OperationResult.SUCCESS);
            result.setMsg("Операция выполнена успешно.");
            double resultOperation = data.getInputAmount() * data.getRate();
            result.setResultAmount(resultOperation);
            result.setInputAmount(data.getInputAmount());
            result.setInputCurrency(data.getInputCurrency());
            result.setRate(data.getRate());
            result.setClient(data.getClient());
            result.setResultCurrency(data.getOutputCurrency());
            data.getCashBox().operation(data.getInputCurrency(), data.getInputAmount(), data.getOutputCurrency());
            return result;
        }
        return null;
    }

}

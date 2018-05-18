package util;

import converter.ConvertionResult;
import enums.OperationResult;
import exception.PrintException;

public class Printer {

    public static StringBuilder print(ConvertionResult result) throws PrintException {
    if(result == null){
        throw new PrintException("Данные отсутствуют");
    }
        if (result != null && result.getOperationResult().equals(OperationResult.SUCCESS)) {
            StringBuilder sb = new StringBuilder();
            sb.append("======================================= \n");
            sb.append("Клиент: " + result.getClient().getFullName() + "\n");
            sb.append("Денег получено: " + String.format("%.2f", result.getInputAmount()));
            sb.append(" " + result.getInputCurrency() + "\n");
            sb.append("Денег выдано: " + String.format("%.2f", result.getResultAmount()));
            sb.append(" " + result.getResultCurrency() + "\n");
            sb.append("Курс: " + String.format("%.2f%n", result.getRate()));
            sb.append("=======================================");
            System.out.println(sb);
            return sb;
        } else {

            StringBuilder sb = new StringBuilder();
            sb.append("=======================================\n");
            sb.append("Ошибка \n");
            sb.append("Операция отменена\n");
            sb.append(result.getMsg() + "\n");
            sb.append("=======================================\n");
            System.out.println(sb);
        }
        return null;
    }


}

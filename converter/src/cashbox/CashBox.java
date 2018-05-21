package cashbox;

import enums.CURRENCY_ENUM;
import services.CentralBankService;

import java.util.HashMap;
import java.util.Map;

public class CashBox {

    private double usdBalance = 10000.00;
    private double rubBalance = 1_000_000.00;
    private Map<CURRENCY_ENUM, Double> balance = new HashMap<>();
    private static CashBox cashBox;

    {
        balance.put(CURRENCY_ENUM.USD, usdBalance);
        balance.put(CURRENCY_ENUM.RUB, rubBalance);

    }

    public static CashBox getInstance() {
        if (cashBox == null) {
            cashBox = new CashBox();
        }
        return cashBox;
    }

    public double getBalance(CURRENCY_ENUM value) {


        if (value.equals(CURRENCY_ENUM.USD)) {
            return balance.get(CURRENCY_ENUM.USD);
        } else {
            return balance.get(CURRENCY_ENUM.RUB);
        }

    }

    private double increaseBalance(CURRENCY_ENUM value, double inputAmount) {

        if (value.equals(CURRENCY_ENUM.USD)) {
            balance.put(CURRENCY_ENUM.USD, balance.get(CURRENCY_ENUM.USD) + inputAmount);
            return balance.get(CURRENCY_ENUM.USD);
        } else {

            balance.put(CURRENCY_ENUM.RUB, balance.get(CURRENCY_ENUM.RUB) + inputAmount);
            return balance.get(CURRENCY_ENUM.RUB);
        }
    }

    private double decreaseBalance(CURRENCY_ENUM value, double inputAmount) {


        if (value.equals(CURRENCY_ENUM.USD)) {

            balance.put(CURRENCY_ENUM.USD, balance.get(CURRENCY_ENUM.USD) - inputAmount /
                    CentralBankService.getCurrentRate(CURRENCY_ENUM.RUB));

            return balance.get(CURRENCY_ENUM.USD);
        } else {


            balance.put(CURRENCY_ENUM.RUB, balance.get(CURRENCY_ENUM.RUB) - inputAmount *
                    CentralBankService.getCurrentRate(CURRENCY_ENUM.USD));
            return balance.get(CURRENCY_ENUM.RUB);
        }


    }

    public void operation(CURRENCY_ENUM inputCurrency, double initialAmount, CURRENCY_ENUM outputCurrency) {

        System.out.printf("LOG: Balance inc %.2f%n", increaseBalance(inputCurrency, initialAmount));
        System.out.printf("LOG: Balance dec %.2f%n", decreaseBalance(outputCurrency, initialAmount));
    }
}

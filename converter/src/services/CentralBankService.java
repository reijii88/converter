package services;

import enums.CURRENCY_ENUM;

public class CentralBankService {

    public static double getCurrentRate(CURRENCY_ENUM inpCurrency) {

        switch (inpCurrency) {
            case EUR:
                return 75.6532;

            case USD:
                return 61.765;

            default:
                return 1.0;

        }

    }

    public double getCurrentRateFromDB(CURRENCY_ENUM currency) {
        switch (currency) {
            case USD:
                return 0.0;
            case RUB:
                return 0.0;
            case EUR:
                return 0.0;
            default:
                return 1;
        }
    }

}

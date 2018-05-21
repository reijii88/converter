import cashbox.CashBox;
import enums.CURRENCY_ENUM;
import org.junit.Assert;
import org.junit.Test;


public class CashBoxValueChanges {
        @Test
        public void CashBoxOperationBalanceDown(){
        CashBox cashBox = new CashBox();
            cashBox.operation(CURRENCY_ENUM.USD,1000, CURRENCY_ENUM.RUB);
            double rubBalance = cashBox.getBalance(CURRENCY_ENUM.USD);
            double usdBalance = cashBox.getBalance(CURRENCY_ENUM.RUB);

            Assert.assertEquals(11000.0, rubBalance,0.1);
            Assert.assertEquals(938235.0, usdBalance,0.1);
        }

    }


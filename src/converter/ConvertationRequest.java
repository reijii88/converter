package converter;

import client.Client;
import enums.CURRENCY_ENUM;

public class ConvertationRequest {

    private Client client;
    private double inputAmount;
    private double outputAmount;
    private CURRENCY_ENUM inputCyrrency;
    private CURRENCY_ENUM outputCyrrency;
    private double rate;
    private CURRENCY_ENUM outputCurrency;

    public ConvertationRequest(ConvertionData data){
        client = data.getClient();
        inputAmount = data.getInputAmount();
        inputCyrrency = data.getInputCurrency();
        outputCyrrency = data.getOutputCurrency();
        rate = data.getRate();
    }

    public ConvertationRequest(Client client, double inputAmount,
                               CURRENCY_ENUM inputCurrency, CURRENCY_ENUM outputCurrency, double rate) {

        this.client = client;
        this.inputAmount = inputAmount;
        this.inputCyrrency = inputCurrency;
        this.outputCyrrency = outputCurrency;
        this.rate = rate;

    }

    public Client getClient() {
        return client;
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public CURRENCY_ENUM getInputCyrrency() {
        return inputCyrrency;
    }

    public CURRENCY_ENUM getOutputCyrrency() {
        return outputCyrrency;
    }

    public double getRate() {
        return rate;
    }

    public double getOutputAmount() {
        return outputAmount;
    }

    public void setOutputAmount(double outputAmount) {
        this.outputAmount = outputAmount;
    }

    public void setOutputCurrency(CURRENCY_ENUM outputCurrency) {
        this.outputCurrency = outputCurrency;
    }
}

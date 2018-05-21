package converter;

import client.Client;
import enums.CURRENCY_ENUM;
import enums.OperationResult;

public class ConvertionResult {

    private OperationResult operationResult;
    private String msg;
    private CURRENCY_ENUM inputCurrency;
    private CURRENCY_ENUM resultCurrency;
    private double inputAmount;
    private double resultAmount;
    private double rate;
    private Client client;
    private String status;

    public ConvertionResult() {

    }

    public ConvertionResult(Client client, double inputAmount, CURRENCY_ENUM inputCyrrency,
                            double resultAmount, CURRENCY_ENUM resultCurrency, double rate) {
        this.client = client;
        this.inputAmount = inputAmount;
        this.inputCurrency = inputCyrrency;
        this.resultCurrency = resultCurrency;
        this.resultAmount = resultAmount;
        this.rate = rate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OperationResult getOperationResult() {
        return operationResult;
    }

    public void setOperationResult(OperationResult operationResult) {
        this.operationResult = operationResult;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CURRENCY_ENUM getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(CURRENCY_ENUM inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(double inputAmount) {
        this.inputAmount = inputAmount;
    }

    public CURRENCY_ENUM getResultCurrency() {
        return resultCurrency;
    }

    public void setResultCurrency(CURRENCY_ENUM resultCurrency) {
        this.resultCurrency = resultCurrency;
    }

    public double getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(double resultAmount) {
        this.resultAmount = resultAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public Client getClient() {
        return client;
    }

    public void setOperatorStatus(String operatorStatus) {
        status = operatorStatus;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

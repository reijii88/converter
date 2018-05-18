package converter;

import cashbox.CashBox;
import client.Client;
import enums.CURRENCY_ENUM;
import interfaces.Employee;
import interfaces.EmployeeFactory;
import operator.Operator;
import operator.OperatorFactory;
import operator.OperatorStudent;
import services.CentralBankService;

public class ConvertionData {

    private Client client;
    private Employee operator;
    private Employee student;
    private double rate;
    private CashBox cashBox;
    private double inputAmount;
    private double outputAmount;
    private CURRENCY_ENUM inputCurrency;
    private CURRENCY_ENUM outputCurrency;
    private EmployeeFactory employeeFactory;
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Employee getStudent() {
        return student;
    }

    public void setStudent(OperatorStudent student) {
        this.student = student;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public CashBox getCashBox() {
        return cashBox;
    }

    public double getInputAmount() {
        return inputAmount;
    }

    public void setInputAmount(double inputAmount) {
        this.inputAmount = inputAmount;
    }

    public double getOutputAmount() {
        return outputAmount;
    }

    public void setOutputAmount(double outputAmount) {
        this.outputAmount = outputAmount;
    }

    public CURRENCY_ENUM getInputCurrency() {
        return inputCurrency;
    }

    public void setInputCurrency(CURRENCY_ENUM inputCurrency) {
        this.inputCurrency = inputCurrency;
    }

    public CURRENCY_ENUM getOutputCurrency() {
        return outputCurrency;
    }

    public void setOutputCurrency(CURRENCY_ENUM outputCurrency) {
        this.outputCurrency = outputCurrency;
    }

    public ConvertionData(Client client, double initialAmount, CURRENCY_ENUM inputCurrency, CURRENCY_ENUM outputCurrency) {
        setClient(client);

        student = new OperatorFactory().getEmployeeFromFactory("student");
        operator = new OperatorFactory().getEmployeeFromFactory("operator");
        cashBox = CashBox.getInstance();
        this.inputAmount = initialAmount;
        this.inputCurrency = inputCurrency;
        this.outputCurrency = outputCurrency;
        this.rate = CentralBankService.getCurrentRate(inputCurrency);
    }

    public ConvertionData(Client client, double inputAmmountField, Object inputCurrency, Object outputCurrency) {
        this.client = client;
        student = new OperatorFactory().getEmployeeFromFactory("student");
        operator = new OperatorFactory().getEmployeeFromFactory("operator");
        cashBox = CashBox.getInstance();
        this.inputAmount = inputAmmountField;
        this.inputCurrency = (CURRENCY_ENUM) inputCurrency;
        this.outputCurrency = (CURRENCY_ENUM) outputCurrency;
        this.rate = CentralBankService.getCurrentRate((CURRENCY_ENUM) inputCurrency);

    }
}
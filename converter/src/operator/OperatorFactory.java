package operator;

import interfaces.Employee;
import interfaces.EmployeeFactory;

public class OperatorFactory implements EmployeeFactory {

    public Employee getEmployeeFromFactory(String employee) {
        if(employee.equals("student")){
            return new OperatorStudent();
        }
        return new Operator();
    }
}

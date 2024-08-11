package ru.prostostudia.homeworkapione;

import java.util.List;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName);
    Employee deleteEmployee(String firstName, String lastName);
    Employee findEmployee(String firstName, String lastName);
    List<Employee> getEmployees();
}

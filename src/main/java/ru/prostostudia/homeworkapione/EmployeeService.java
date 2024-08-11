package ru.prostostudia.homeworkapione;

import org.springframework.stereotype.Service;
import ru.prostostudia.homeworkapione.exceptions.EmployeeAlreadyAddedException;
import ru.prostostudia.homeworkapione.exceptions.EmployeeNotFoundException;
import ru.prostostudia.homeworkapione.exceptions.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private final List<Employee> employeesBook = new ArrayList<>();
    private int maxEmployees = Integer.MAX_VALUE;

    public EmployeeService() {
        demoFill();
    }

    public void demoFill() {
        employeesBook.clear();
        addEmployee("Илья", "Бабушкин");
        addEmployee("Игорь", "Мусинькин");
        addEmployee("Виталий", "Хазбулатов");
        addEmployee("Иван", "Познер");
        addEmployee("Исаакий", "Волондемортов");
        addEmployee("Ирина", "Дудина");
        addEmployee("Иннокентий", "Смактуновский");
        addEmployee("Наталья", "Бузинова");
        addEmployee("Навелий", "Навеяло");
        addEmployee("Прасковья", "Прошкина");
        setMaxEmployees(10);
    }

    public List<Employee> getEmployees() {
        return employeesBook;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        if (employeesBook.size() > maxEmployees) throw new EmployeeStorageIsFullException();
        this.maxEmployees = maxEmployees;
    }

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        if (employeesBook.size() >= maxEmployees) throw new EmployeeStorageIsFullException();
        try {
            findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            Employee employee = new Employee(firstName, lastName);
            employeesBook.add(employee);
            return employee;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName,lastName);
        employeesBook.remove(employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeesBook) {
            if (employee.getFirstName().equals(firstName) && employee.getLastName().equals(lastName)) return employee;
        }
        throw new EmployeeNotFoundException();
    }
}

package ru.prostostudia.homeworkapione;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.prostostudia.homeworkapione.exceptions.EmployeeAlreadyAddedException;
import ru.prostostudia.homeworkapione.exceptions.EmployeeNotFoundException;
import ru.prostostudia.homeworkapione.exceptions.EmployeeStorageIsFullException;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceInterface employeeService;


    public EmployeeController(EmployeeServiceInterface employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public Object employeeList() {
        return employeeService.getEmployees();
    }

    @GetMapping(path = "/del")
    public Object employeeDelete(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.deleteEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/add")
    public Object employeeAdd(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.addEmployee(firstName, lastName);
        } catch (EmployeeAlreadyAddedException | EmployeeStorageIsFullException e) {
            return e.getMessage();
        }
    }

    @GetMapping(path = "/find")
    public Object employeeFind(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName ) {
        try {
            return employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            return e.getMessage();
        }
    }



}

package ru.prostostudia.homeworkapione.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("EmployeeNotFound");
    }
}

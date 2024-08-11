package ru.prostostudia.homeworkapione.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("EmployeeAlreadyAdded");
    }
}

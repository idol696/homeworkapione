package ru.prostostudia.homeworkapione.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("ArrayIsFull");
    }
}

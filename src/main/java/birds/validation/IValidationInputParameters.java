package main.java.birds.validation;

import main.java.birds.my_exceptions.InvalidDataException;

public interface IValidationInputParameters<T> {

    boolean isValid(T param) throws InvalidDataException;
}

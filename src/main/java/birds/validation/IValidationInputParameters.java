package main.java.birds.validation;

import main.java.birds.entities.Bird;
import main.java.birds.my_exceptions.InvalidDataException;

public interface IValidationInputParameters {

    boolean isValidStringParam(String param, int maxLength) throws InvalidDataException;
    boolean isValidSize(double param) throws InvalidDataException;
}

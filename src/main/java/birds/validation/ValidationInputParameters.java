package main.java.birds.validation;

import main.java.birds.my_exceptions.InvalidDataException;

public class ValidationInputParameters implements IValidationInputParameters {

    @Override
    public boolean isValidStringParam(String param, int maxLength) throws InvalidDataException {

        if (param.length() > maxLength) return false;

        for (int i = 0; i < param.length(); i++) {

            char ch = param.charAt(i);

            if (!Character.isLetter(ch) && !Character.isWhitespace(ch))
                throw new InvalidDataException("Input parameter is not valid!");
        }
        return true;
    }

    @Override
    public boolean isValidSize(double param) throws InvalidDataException {

        if (param > 0.0) return true;
        throw new InvalidDataException("Input parameter is not valid: param <= 0");
    }
}

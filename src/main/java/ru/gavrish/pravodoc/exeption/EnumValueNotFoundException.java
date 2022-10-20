package ru.gavrish.pravodoc.exeption;

public class EnumValueNotFoundException extends RuntimeException{

    public EnumValueNotFoundException(String message) {
        super(message);
    }
}

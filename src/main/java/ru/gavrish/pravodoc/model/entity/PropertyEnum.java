package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;

import java.util.Arrays;

public enum PropertyEnum {

    RECOGNITION_OF_OWNERSHIP_OF_PROPERTY("ПРИЗНАНИЕ_ПРАВА_СОБСТВЕННОСТИ_НА_ИМУЩЕСТВО"),
    DIVISION_OF_PROPERTY("РАЗДЕЛ_ИМУЩЕСТВА"),
    ALLOCATION_OF_A_SHARE_IN_PROPERTY("ВЫДЕЛЕНИЕ_ДОЛИ_В_СОБСТВЕННОСТИ"),
    CLAIMING_PROPERTY_FROM_OTHER_PERSONS("ИСТРЕБОВАНИЕ_ИМУЩЕСТВА_У_ДРУГИХ_ЛИЦ"),
    DETERMINING_THE_PROCEDURE_FOR_USING_PROPERTY("ОПРЕДЕЛЕНИЕ_ПОРЯДКА_ПОЛЬЗОВАНИЯ_ИМУЩЕСТВОМ"),
    REMOVAL_OF_OBSTACLES_IN_THE_USE_OF_PROPERTY("УСТРАНЕНИЕ_ПРЕПЯТСТВИЙ_В_ПОЛЬЗОВАНИИ_ИМУЩЕСТВОМ"),
    EASE("СЕРВИТУТ"),
    RECOGNITION_OF_THE_TRANSACTION_AS_INVALID("ПРИЗНАНИЕ_СДЕЛКИ_НЕДЕЙСТВИТЕЛЬНОЙ");


    private final String value;

    PropertyEnum(String value) {
        this.value = value;
    }

    public static PropertyEnum fromValue(String value) {
        return Arrays.stream(PropertyEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected PropertyEnum value %s", value)));
    }
}

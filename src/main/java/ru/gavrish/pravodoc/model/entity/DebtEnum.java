package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;

import java.util.Arrays;

public enum DebtEnum {

    COLLECTION_OF_FUNDS_FROM_THE_DEBTOR("ВОССТАНОВЛЕНИЕ_СРОКА_ДЛЯ_ПРИНЯТИЯ_НАСЛЕДСТВА"),
    DECLARATION_OF_THE_DEBTOR_BANKRUPT("ПРИЗНАНИЕ_ПРИНЯВШИМ_НАСЛЕДСТВО"),
    COLLECTION_OF_A_PENALTY("УСТАНОВЛЕНИЕ_ФАКТА_ПРИНЯТИЯ_НАСЛЕДСТВА"),
    COLLECTION_OF_INTEREST("УСТАНОВЛЕНИЕ_ПРАВА_СОБСТВЕННОСТИ_НА_НАСЛЕДСТВЕННОЕ_ИМУЩЕСТВО");


    private final String value;

    DebtEnum(String value) {
        this.value = value;
    }

    public static DebtEnum fromValue(String value) {
        return Arrays.stream(DebtEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected DebtEnum value %s", value)));
    }
}

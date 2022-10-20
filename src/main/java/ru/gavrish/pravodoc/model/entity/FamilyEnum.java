package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;

import java.util.Arrays;

public enum FamilyEnum {

    DISSOLUTION_OF_MARRIAGE("РАСТОРЖЕНИЕ_БРАКА"),
    RECOGNITION_OF_MARRIAGE_AS_INVALID("ПРИЗНАНИЕ_БРАКА_НЕДЕЙСТВИТЕЛЬНЫМ"),
    DIVISION_OF_JOINTLY_ACQUIRED_PROPERTY("РАЗДЕЛ_СОВМЕСТНО_НАЖИТОГО_ИМУЩЕСТВА"),
    CANCELLATION_OF_THE_MARRIAGE_CONTRACT("РАСТОРЖЕНИЕ_БРАЧНОГО_ДОГОВОРА"),
    COLLECTION_OF_ALIMONY("ВЗЫСКАНИЕ_АЛИМЕНТОВ"),
    ESTABLISHMENT_OF_PATERNITY("УСТАНОВЛЕНИЕ_ОТЦОВСТВА"),
    DEPRIVATION_OF_PARENTAL_RIGHT("ЛИШЕНИЕ_РОДИТЕЛЬСКИХ_ПРАВ"),
    RESTORATION_OF_PARENTAL_RIGHT("ВОССТАНОВЛЕНИЕ_РОДИТЕЛЬСКИХ_ПРАВ");


    private final String value;

    FamilyEnum(String value) {
        this.value = value;
    }

    public static FamilyEnum fromValue(String value) {
        return Arrays.stream(FamilyEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected FamilyEnum value %s", value)));
    }
}


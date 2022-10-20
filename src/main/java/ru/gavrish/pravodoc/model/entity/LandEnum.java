package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;

import java.util.Arrays;

public enum LandEnum {

    RECOGNITION_OF_THE_RIGHT_TO_A_LAND_PLOT("ПРИЗНАНИЕ_ПРАВА_НА_ЗЕМЕЛЬНЫЙ_УЧАСТОК"),
    RELINQUISHMENT_OF_RIGHT_TO_A_LAND_PLOT("ОТКАЗ_ОТ_ПРАВ_НА_ЗЕМЕЛЬНЫЙ_УЧАСТОК"),
    CHANGE_OR_TERMINATION_OF_LAND_LEGAL_RELATIONS("ИЗМЕНЕНИЕ_ИЛИ_ПРЕКРАЩЕНИЕ_ЗЕМЕЛЬНЫХ_ПРАВООТНОШЕНИЙ"),
    COMPENSATION_FOR_LOSSES_AND_HARM("ВОЗМЕЩЕНИЕ_УБЫТКОВ_И_ВРЕДА"),
    TERMINATION_OR_CHANGE_OF_LAND_RELATIONS("ПРЕКРАЩЕНИЕ_ИЛИ_ИЗМЕНЕНИЕ_ЗЕМЕЛЬНЫХ_ПРАВООТНОШЕНИЙ"),
    DETERMINATION_OF_THE_BOUNDARIES_OF_THE_SITE("ОПРЕДЕЛЕНИЕ_ГРАНИЦ_УЧАСТКА"),
    RESTORATION_OF_THE_BOUNDARIES_OF_THE_SITE("ВОССТАНОВЛЕНИЕ_ГРАНИЦ_УЧАСТКА"),
    CHALLENGE_OF_SURVEY_RESULTS("ОСПАРИВАНИЕ_РЕЗУЛЬТАТОВ_МЕЖЕВАНИЯ"),
    CORRECTION_OF_CADASTRAL_ERROR("ИСПРАВЛЕНИЕ_КАДАСТРОВОЙ_ОШИБКИ");


    private final String value;

    LandEnum(String value) {
        this.value = value;
    }

    public static LandEnum fromValue(String value) {
        return Arrays.stream(LandEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected FamilyEnum value %s", value)));
    }
}

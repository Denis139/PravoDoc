package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;
import java.util.Arrays;

public enum LegacyEnum {

    RESTORATION_OF_THE_TERM_FOR_ACCEPTING_THE_INHERITANCE("ВОССТАНОВЛЕНИЕ_СРОКА_ДЛЯ_ПРИНЯТИЯ_НАСЛЕДСТВА"),
    RECOGNITION_BY_THOSE_WHO_ACCEPTED_THE_INHERITANCE("ПРИЗНАНИЕ_ПРИНЯВШИМ_НАСЛЕДСТВО"),
    ESTABLISHMENT_OF_THE_FACT_OF_ACCEPTANCE_OF_THE_INHERITANCE("УСТАНОВЛЕНИЕ_ФАКТА_ПРИНЯТИЯ_НАСЛЕДСТВА"),
    ESTABLISHMENT_OF_THE_RIGHT_OF_OWNERSHIP_OF_THE_INHERITED_PROPERTY("УСТАНОВЛЕНИЕ_ПРАВА_СОБСТВЕННОСТИ_НА_НАСЛЕДСТВЕННОЕ_ИМУЩЕСТВО"),
    CHALLENGE_OF_THE_WILL("ОСПАРИВАНИЕ_ЗАВЕЩАНИЯ"),
    INCLUSION_OF_PROPERTY_IN_THE_ESTATE("ВКЛЮЧЕНИЕ_ИМУЩЕСТВА_В_НАСЛЕДСТВЕННУЮ_МАССУ"),
    ALLOCATION_OF_THE_MANDATORY_SHARE("ВЫДЕЛ_ОБЯЗАТЕЛЬНОЙ_ДОЛИ"),
    RECOGNITION_AS_AN_UNWORTHY_HEAR("ПРИЗНАНИЕ_НЕДОСТОЙНЫМ_НАСЛЕДНИКОМ");


    private final String value;

    LegacyEnum(String value) {
        this.value = value;
    }

    public static LegacyEnum fromValue(String value) {
        return Arrays.stream(LegacyEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected LegacyEnum value %s", value)));
    }
}

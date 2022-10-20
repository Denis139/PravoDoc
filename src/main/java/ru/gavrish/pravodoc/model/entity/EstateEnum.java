package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;

import java.util.Arrays;

public enum EstateEnum {

    CHALLENGE_OF_TRANSACTIONS("ОСПАРИВАНИЕ_СДЕЛОК"),
    RECOGNITION_OF_A_TRANSACTION_NOT_CONCLUDED("ПРИЗНАНИЕ_СДЕЛКИ_НЕЗАКЛЮЧЕННОЙ"),
    RECOGNITION_OF_A_TRANSACTION_AS_ILLEGAL("ПРИЗНАНИЕ_СДЕЛКИ_НЕЗАКОННОЙ"),
    COMPULSORY_REGISTRATION_OF_THE_TRANSFER_OF_OWNERSHIP("ПРИНУДИТЕЛЬНАЯ_РЕГИСТРАЦИЯ_ПЕРЕХОДА_ПРАВА_СОБСТВЕННОСТИ"),
    REAL_ESTATE_ARBITRATION_DISPUTE("АРБИТРАЖНЫЙ_СПОР_ПО_НЕДВИЖИМОСТИ"),
    DISPUTE_UNDER_THE_CONTRACT_OF_SALE_PURCHASE("СПОР_ПО_ДОГОВОРУ_КУПЛИ_ПРОДАЖИ");


    private final String value;

    EstateEnum(String value) {
        this.value = value;
    }

    public static EstateEnum fromValue(String value) {
        return Arrays.stream(EstateEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected EstateEnum value %s", value)));
    }
}

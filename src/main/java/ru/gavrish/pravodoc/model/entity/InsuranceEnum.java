package ru.gavrish.pravodoc.model.entity;

import ru.gavrish.pravodoc.exeption.EnumValueNotFoundException;
import java.util.Arrays;

public enum InsuranceEnum {

    INTENTIONAL_DELAY_IN_PAYMENT("УМЫШЛЕННОЕ_ЗАДЕРЖАНИЕ_ВЫПЛАТЫ"),
    LEGAL_ACTION_BY_THE_INSURER_AGAINST_THE_CLIENT("ПОДАЧА_СУДЕБНОГО_ИСКА_СТРАХОВЩИКОМ_НА_КЛИЕНТА"),
    BANKRUPTCY_OF_AN_INSURANCE_COMPANY("БАНКРОТСТВО_СТРАХОВОЙ_КОМПАНИИ"),
    DELIBERATE_UNDERESTIMATION_OF_COMPENSATION_PAYMENT("НАМЕРЕННОЕ_ЗАНИЖЕНИЕ_РАЗМЕРА_КОМПЕНСАЦИОННЫХ_ВЫПЛАТ"),
    ILLEGAL_TERMINATION_OF_AN_INSURANCE_CONTRACT("НЕЗАКОННОЕ_РАСТОРЖЕНИЕ_ДОГОВОРА_СТРАХОВАНИЯ"),
    REJECTION_OF_INSURANCE_PAYMENTS("ОТКАЗ_В_СТРАХОВЫХ_ВЫПЛАТАХ"),
    REFUSAL_TO_ACCEPT_DOCUMENTS("ОТКАЗ_В_ПРИЕМЕ_ДОКУМЕНТОВ");


    private final String value;

    InsuranceEnum(String value) {
        this.value = value;
    }

    public static InsuranceEnum fromValue(String value) {
        return Arrays.stream(InsuranceEnum.values())
                .filter(o->o.value.equals(value))
                .findFirst()
                .orElseThrow(()-> new EnumValueNotFoundException(String.format("Unexpected InsuranceEnum value %s", value)));
    }
}

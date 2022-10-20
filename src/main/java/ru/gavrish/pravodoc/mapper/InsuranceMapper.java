package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.InsuranceAddRequest;
import ru.gavrish.pravodoc.model.dto.request.InsuranceUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.InsuranceView;
import ru.gavrish.pravodoc.model.entity.InsuranceDisputes;

public interface InsuranceMapper {

    InsuranceDisputes from(InsuranceAddRequest source);

    InsuranceView fromRevers(InsuranceDisputes source);

    InsuranceDisputes merge(InsuranceDisputes target, InsuranceUpdateRequest source);
}

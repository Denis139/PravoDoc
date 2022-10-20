package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.FamilyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.FamilyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.FamilyView;
import ru.gavrish.pravodoc.model.entity.FamilyDisputes;

public interface FamilyMapper {

    FamilyDisputes from(FamilyAddRequest source);

    FamilyView fromRevers(FamilyDisputes source);

    FamilyDisputes merge(FamilyDisputes target, FamilyUpdateRequest source);
}

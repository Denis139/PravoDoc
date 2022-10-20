package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.LegacyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LegacyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LegacyView;
import ru.gavrish.pravodoc.model.entity.LegacyDisputes;

public interface LegacyMapper {

    LegacyDisputes from(LegacyAddRequest source);

    LegacyView fromRevers(LegacyDisputes source);

    LegacyDisputes merge(LegacyDisputes target, LegacyUpdateRequest source);
}

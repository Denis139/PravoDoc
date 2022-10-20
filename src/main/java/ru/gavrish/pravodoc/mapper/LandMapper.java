package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.LandAddRequest;
import ru.gavrish.pravodoc.model.dto.request.LandUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.LandView;
import ru.gavrish.pravodoc.model.entity.LandDisputes;

public interface LandMapper {

    LandDisputes from(LandAddRequest source);

    LandView fromRevers(LandDisputes source);

    LandDisputes merge(LandDisputes target, LandUpdateRequest source);
}

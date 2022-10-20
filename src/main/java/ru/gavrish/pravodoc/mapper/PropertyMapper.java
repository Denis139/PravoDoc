package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.PropertyAddRequest;
import ru.gavrish.pravodoc.model.dto.request.PropertyUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.PropertyView;
import ru.gavrish.pravodoc.model.entity.PropertyDisputes;

public interface PropertyMapper {

    PropertyDisputes from(PropertyAddRequest source);

    PropertyView fromRevers(PropertyDisputes source);

    PropertyDisputes merge(PropertyDisputes target, PropertyUpdateRequest source);
}

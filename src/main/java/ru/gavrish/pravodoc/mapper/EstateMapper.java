package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.EstateAddRequest;
import ru.gavrish.pravodoc.model.dto.request.EstateUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.EstateView;
import ru.gavrish.pravodoc.model.entity.EstateDisputes;

public interface EstateMapper {

    EstateDisputes from(EstateAddRequest source);

    EstateView fromRevers(EstateDisputes source);

    EstateDisputes merge(EstateDisputes target, EstateUpdateRequest source);
}

package ru.gavrish.pravodoc.mapper;

import ru.gavrish.pravodoc.model.dto.request.DebtAddRequest;
import ru.gavrish.pravodoc.model.dto.request.DebtUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.DebtView;
import ru.gavrish.pravodoc.model.entity.DebtDisputes;

public interface DebtMapper {

    DebtDisputes from(DebtAddRequest source);

    DebtView fromRevers(DebtDisputes source);

    DebtDisputes merge(DebtDisputes target, DebtUpdateRequest source);
}

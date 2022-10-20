package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.DebtAddRequest;
import ru.gavrish.pravodoc.model.dto.request.DebtUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.DebtView;
import java.util.List;
import java.util.UUID;

public interface DebtDomainService {

    UUID add(DebtAddRequest request);

    DebtView get(UUID id);

    List<DebtView> getAll();

    DebtView update(UUID id, DebtUpdateRequest request);

    Boolean delete(UUID id);
}

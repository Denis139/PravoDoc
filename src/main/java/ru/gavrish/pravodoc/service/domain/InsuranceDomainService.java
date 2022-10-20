package ru.gavrish.pravodoc.service.domain;

import ru.gavrish.pravodoc.model.dto.request.InsuranceAddRequest;
import ru.gavrish.pravodoc.model.dto.request.InsuranceUpdateRequest;
import ru.gavrish.pravodoc.model.dto.view.InsuranceView;
import java.util.List;
import java.util.UUID;

public interface InsuranceDomainService {

    UUID add(InsuranceAddRequest request);

    InsuranceView get(UUID id);

    List<InsuranceView> getAll();

    InsuranceView update(UUID id, InsuranceUpdateRequest request);

    Boolean delete(UUID id);
}
